package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.PedidoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.PedidoFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoFacadeImpl implements PedidoFacade {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public List<PedidoDto> findAll(Integer page, Integer pageSize){

        var pedidolist  = pedidoService.findAll(page,pageSize);
        List<PedidoDto> lista = new ArrayList<>();
        for (Pedido ped: pedidolist
             ) {
            lista.add(PedidoMapper.convertModelToDto(ped,"consulta"));
        }
        return lista;
    }

    @Override
    public List<PedidoDto> findfinally(Integer page, Integer pageSize) {
        var pedidolist  = pedidoService.findFinally(page,pageSize);
        List<PedidoDto> lista = new ArrayList<>();
        for (Pedido ped: pedidolist
        ) {
            lista.add(PedidoMapper.convertModelToDto(ped,"consulta"));
        }
        return lista;
    }

    @Override
    public PedidoDto findById(Integer id) throws MyRunTimeException {
        var pedido  = pedidoService.findById(id);
        var pedidoDto = PedidoMapper.convertModelToDto(pedido,"consulta");
        return  pedidoDto;
    }

    @Override
    public PedidoDto create(PedidoDto ped){
        return pedidoService.create(ped);
    }

    @Override
    public PedidoDto update(PedidoDto ped) throws MyRunTimeException {
        return pedidoService.update(ped);
    }

}
