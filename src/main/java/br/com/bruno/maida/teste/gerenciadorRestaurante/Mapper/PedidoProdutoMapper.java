package br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.PedidoProduto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;

public class PedidoProdutoMapper {

    public static PedidoProdutoDto convertModelToDto(PedidoProduto origin){
        ProdutoDto prod = new ProdutoDto();
        prod.setId(origin.getProduto().getId());
        PedidoDto ped = new PedidoDto();
        ped.setId(origin.getPedido().getId());
        PedidoProdutoDto dto = new PedidoProdutoDto();
        dto.setId(origin.getId());
        dto.setProduto(prod);
        dto.setPedido(ped);
        return dto;
    }

    public static  PedidoProduto convertDtoToModel(PedidoProdutoDto origin){
        Produto prod = new Produto();
        prod.setId(origin.getProduto().getId());
        Pedido ped = new Pedido();
        ped.setId(origin.getPedido().getId());
        PedidoProduto dto = new PedidoProduto();
        dto.setId(origin.getId());
        dto.setProduto(prod);
        dto.setPedido(ped);
        return dto;
    }
}
