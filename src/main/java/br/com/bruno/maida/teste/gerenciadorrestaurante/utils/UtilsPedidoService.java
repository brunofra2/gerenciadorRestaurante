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
                .build();

    }
    public static void salvarManytoMany(Pedido ped, ProdutoPedidoRepository produtoPedidoRepository){
        for (Produto pro : ped.getProdutoList()
        ) {
            produtoPedidoRepository.save(new ProdutoPedido().builder()
                    .idProduto(pro)
                    .idPedido(ped)
                    .build());
        }
    }

    public static PedidoDto criarPedido(PedidoDto ped, ProdutoRepository produtoRepository
            , ClienteRepository clienteRepository){
        if (ped == null) throw new RequiredObjectIsNullException();
        var vlrTotal = 0d;
        for (ProdutoDto prod: ped.getProdutoDtolist()
        ) {
            var vlorProdSelect = produtoRepository.findById(prod.getId()).get();
            vlrTotal += vlorProdSelect.getValor();

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
