package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoPedidoRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UtilServices {

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
                    .produtoList( produtoList)
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
                    .produtoList( produtoList)
                    .build();

    }

    public static  String captUsuarioLogado(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email;

        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        } else {
            email = principal.toString();
        }
        return email;
    }
}
