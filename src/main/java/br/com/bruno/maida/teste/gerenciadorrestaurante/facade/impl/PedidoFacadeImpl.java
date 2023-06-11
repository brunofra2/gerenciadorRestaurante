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

    public List<PedidoDto> findAll(){

        var pedidolist  = pedidoService.findAll();
        List<PedidoDto> lista = new ArrayList<>();
        for (Pedido ped: pedidolist
             ) {
            lista.add(PedidoMapper.convertModelToDto(ped,"consulta"));
        }
        return lista;
    }

    @Override
    public List<PedidoDto> findfinally() {
        var pedidolist  = pedidoService.findFinally();
        List<PedidoDto> lista = new ArrayList<>();
        for (Pedido ped: pedidolist
        ) {
            lista.add(PedidoMapper.convertModelToDto(ped,"consulta"));
        }
        return lista;
    }

    public PedidoDto findById(Integer id) throws MyRunTimeException {
        var pedido  = pedidoService.findById(id);
        var pedidoDto = PedidoMapper.convertModelToDto(pedido,"consulta");
        return  pedidoDto;
    }

    public PedidoDto create(PedidoDto ped){
        return pedidoService.create(ped);
    }

    public PedidoDto update(PedidoDto ped) throws MyRunTimeException {
        return pedidoService.update(ped);
    }

    public void delete(Integer id){
        pedidoService.delete(id);
    }
}
