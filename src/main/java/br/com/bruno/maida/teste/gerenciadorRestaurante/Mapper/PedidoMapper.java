package br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;

public class PedidoMapper {

    public static PedidoDto convertModelToDto(Pedido origin){
        ClienteDto cli = new ClienteDto();
        cli.setId(origin.getFkCliente().getId());
        PedidoDto dto = new PedidoDto();
        dto.setId(origin.getId());
        dto.setTotal(origin.getTotal());
        dto.setStatus(origin.getStatus());
        dto.setFkCliente(cli);
        return dto;
    }

    public static Pedido convertDtoToModel(PedidoDto origin){
        Cliente cli = new Cliente();
        cli.setId(origin.getFkCliente().getId());
        Pedido model = new Pedido();
        model.setId(origin.getId());
        model.setTotal(origin.getTotal());
        model.setStatus(origin.getStatus());
        model.setFkCliente(cli);
        return model;
    }
}
