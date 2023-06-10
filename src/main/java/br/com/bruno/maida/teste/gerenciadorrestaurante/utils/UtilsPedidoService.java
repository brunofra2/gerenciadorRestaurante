package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.ProdutoPedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoPedidoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;

public class UtilsPedidoService {


    public static List<Pedido> trazerprodutos(List<Pedido> pedidos, ProdutoPedidoRepository produtoPedidoRepository){
        List<Pedido> pedidoListComProdutos = new ArrayList<>();
        List<Produto> produtoList = new ArrayList<>();

        for (Pedido pe: pedidos
        ) {
            for (Integer i: produtoPedidoRepository.findByIdPedido(pe.getId())
            ) {
                produtoList.add(new Produto().builder()
                        .id(i)
                        .build());
            }
            pedidoListComProdutos.add( new Pedido().builder()
                    .id(pe.getId())
                    .total(pe.getTotal())
                    .status(pe.getStatus())
                    .fkCliente(pe.getFkCliente())
                    .produtoList(produtoList)
                    .build());
        }
        return pedidoListComProdutos;
    }

    public static Pedido trazerprodutosbyId(Pedido pedido, ProdutoPedidoRepository produtoPedidoRepository){

        List<Produto> produtoList = new ArrayList<>();


        for (Integer i: produtoPedidoRepository.findByIdPedido(pedido.getId())
        ) {
            produtoList.add(new Produto().builder()
                    .id(i)
                    .build());
        }
        return new Pedido().builder()
                .id(pedido.getId())
                .total(pedido.getTotal())
                .status(pedido.getStatus())
                .fkCliente(pedido.getFkCliente())
                .produtoList(produtoList)
                .build();

    }
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

        ped.setStatus("cadastrado");
        ped.setTotal(vlrTotal);
        ped.setFkCliente(new ClienteDto().builder()
                .id(usuarioLogado.getId())
                .fkUsuario(
                        new UsuarioDto().builder()
                                .id(usuarioLogado.getFkUsuario().getId()).build()
                ).build());
        return ped;
    }
}
