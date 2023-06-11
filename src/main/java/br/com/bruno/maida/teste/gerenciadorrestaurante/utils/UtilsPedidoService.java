package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.SituacoesDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.ProdutoPedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.Situacoes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoPedidoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;

public class UtilsPedidoService {

        /**metodo para salvar na tabela produto_pedito e retornar um responde do pedido criado**/
    public static PedidoDto salvarManytoMany(Pedido ped, ProdutoPedidoRepository produtoPedidoRepository
            ,PedidoDto pedDto,PedidoDto vo,ProdutoRepository produtoRepository
    ,ClienteRepository clienteRepository){

        List<ProdutoPedido> produtoPedidoList = new ArrayList<>();
        for (int i = 0; i < ped.getProdutoList().size(); i++){
            produtoPedidoList.add(new ProdutoPedido().builder()
                    .idProduto(ped.getProdutoList().get(i))
                    .quantidade(pedDto.getProdutoDtolist().get(i).getQtd())
                    .idPedido(ped)
                    .build());
        }
        /**busca as informações do cliente que esta relacionado ao pedido**/
        var cliente = clienteRepository.findById(vo.getFkCliente().getId());
        vo.setFkCliente(new ClienteDto().builder().name(cliente.get().getName())
                .cpfCnpj(cliente.get().getCpfCnpj())
                .telefone(cliente.get().getTelefone()).build());
        vo.setProdutoDtolist(listarProdutos(produtoPedidoList,produtoPedidoRepository,produtoRepository));
        return vo;
    }

    /**este método busca as informações dos produtos selecionados pelo cliente e suas informações**/
    private static List<ProdutoDto> listarProdutos(List<ProdutoPedido> produtoPedidoList
    ,ProdutoPedidoRepository produtoPedidoRepository,ProdutoRepository produtoRepository){
        List<ProdutoDto> produtoDtoList = new ArrayList<>();
        for (ProdutoPedido pp: produtoPedidoList
        ) {
            var produto = produtoRepository.findById(pp.getIdProduto().getId());
            produtoDtoList.add(new ProdutoDto().builder()
                    .qtd(pp.getQuantidade())
                    .nome(produto.get().getNome())
                    .valor(produto.get().getValor()).build());
            produtoPedidoRepository.save(pp);
        }
        return produtoDtoList;
    }
    /** criar o pedido no layaut solicitado**/
    public static PedidoDto criarPedido(PedidoDto ped, ProdutoRepository produtoRepository
            , ClienteRepository clienteRepository){
        if (ped == null) throw new RequiredObjectIsNullException();
        var vlrTotal = 0d;
        for (ProdutoDto prod: ped.getProdutoDtolist()
        ) {
            var vlorProdSelect = produtoRepository.findById(prod.getId()).get();
            vlrTotal += vlorProdSelect.getValor()*prod.getQtd();

        }
        var usuarioLogado = clienteRepository.verifyClienteLogado(captUsuarioLogado());

        ped.setStatus(SituacoesDto.CADASTRADO);
        ped.setTotal(vlrTotal);
        ped.setFkCliente(new ClienteDto().builder()
                .id(usuarioLogado.getId())
                .fkUsuario(
                        new UsuarioDto().builder()
                                .id(usuarioLogado.getFkUsuario().getId()).build()
                ).build());
        return ped;
    }

    /** constrói o layout para alteração do pedido**/
    public static PedidoDto alterarPedido(Pedido pedido, PedidoDto ped, UsuarioRepository usuarioRepository) throws MyRunTimeException {
        if (ped == null) throw new RequiredObjectIsNullException();
        var usuarioLogado = usuarioRepository.findUsuario(captUsuarioLogado());
        if(usuarioLogado.getTypeUser() == TipoUsuario.CLIENTE
                && ped.getStatus() == SituacoesDto.CANCELADO
                && pedido.getStatus() != Situacoes.CADASTRADO){
            throw  new MyRunTimeException("Pedido não pode ser cancelado pelo cliente na situação em que se encontra");
        }
        if(usuarioLogado.getTypeUser() == TipoUsuario.CLIENTE
        && ped.getStatus() != SituacoesDto.CANCELADO){
            throw  new MyRunTimeException("Ação não permitida");

        }
        if(usuarioLogado.getTypeUser() == TipoUsuario.GESTOR
                && pedido.getStatus().ordinal() > 1
        && ped.getStatus() == SituacoesDto.CANCELADO){
            throw  new MyRunTimeException("Ação não permitida");
        }
        List<ProdutoDto> produtoList = new ArrayList<>();
        for (Produto p: pedido.getProdutoList()
        ) {
            produtoList.add(new ProdutoDto().builder().id(p.getId()).build());
        }
        ped.setTotal(pedido.getTotal());
        ped.setStatus(ped.getStatus());
        ped.setFkCliente(new ClienteDto().builder()
                .id(pedido.getFkCliente().getId())
                .fkUsuario(
                        new UsuarioDto().builder()
                                .id(pedido.getFkCliente().getFkUsuario().getId()).build()
                ).build());
        ped.setProdutoDtolist(produtoList);
        return ped;
    }

    public static PedidoDto organizarInformacoes(PedidoDto pedidoDto,ClienteRepository clienteRepository
            ,ProdutoRepository produtoRepository,ProdutoPedidoRepository produtoPedidoRepository){
        var cliente = clienteRepository.findById(pedidoDto.getFkCliente().getId());
        pedidoDto.setFkCliente(new ClienteDto().builder().name(cliente.get().getName())
                .cpfCnpj(cliente.get().getCpfCnpj())
                .telefone(cliente.get().getTelefone()).build());
        List<ProdutoDto> produtoDtoList = new ArrayList<>();
        var idPedido = pedidoDto.getId();
        var produtoPedidoList = produtoPedidoRepository.findByIdPedidoModel(idPedido);
        for (ProdutoPedido pp: produtoPedidoList
        ) {
            var produto = produtoRepository.findById(pp.getIdProduto().getId());
            produtoDtoList.add(new ProdutoDto().builder()
                    .qtd(pp.getQuantidade())
                    .nome(produto.get().getNome())
                    .valor(produto.get().getValor()).build());
        }
        pedidoDto.setProdutoDtolist(produtoDtoList);
        return pedidoDto;
    }
}
