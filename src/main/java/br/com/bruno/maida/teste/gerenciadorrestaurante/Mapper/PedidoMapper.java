package br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PedidoMapper {

    public static PedidoDto convertModelToDto(Pedido origin){
        ClienteDto clienteDto = new ClienteDto().builder()
                .id(origin.getFkCliente().getId())
                .fkUsuario(new UsuarioDto().builder().id(origin.getFkCliente().getFkUsuario().getId()).build())
                .build();
        List<ProdutoDto> produtoList = new ArrayList<>();
        for (Produto pro : origin.getProdutoList()
        ) {
            produtoList.add(new ProdutoDto().builder().id(pro.getId()).build());
        }
        return  new PedidoDto().builder()
                .id(origin.getId())
                .total(origin.getTotal())
                .status(origin.getStatus())
                .fkCliente(clienteDto)
                .produtoDtolist(produtoList)
                .build();
    }

    public static Pedido convertDtoToModel(PedidoDto origin){
        Cliente cliente = new Cliente().builder()
                .id(origin.getFkCliente().getId())
                .fkUsuario(new Usuario().builder().id(origin.getFkCliente().getFkUsuario().getId()).build())
                .build();
        List<Produto> produtoList = new ArrayList<>();
        for (ProdutoDto pro : origin.getProdutoDtolist()
             ) {
            produtoList.add(new Produto().builder().id(pro.getId()).build());
        }
        return  new Pedido().builder()
                .id(origin.getId())
                .total(origin.getTotal())
                .status(origin.getStatus())
                .fkCliente(cliente)
                .produtoList(produtoList)
                .build();
    }
}
