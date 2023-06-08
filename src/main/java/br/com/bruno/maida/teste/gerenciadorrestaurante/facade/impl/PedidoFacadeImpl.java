package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.PedidoFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoFacadeImpl implements PedidoFacade {

    @Autowired
    private PedidoService pedidoService;

    public List<PedidoDto> findAll(){
        return DozerMapper.parseListObjects(pedidoService.findAll(),PedidoDto.class);
    }

    public PedidoDto findById(Integer id){
        var pedido  = pedidoService.findById(id);
        var pedidoDto = DozerMapper.parseObject(pedido,PedidoDto.class);
        return  pedidoDto;
    }

    public PedidoDto create(PedidoDto ped){
        return pedidoService.create(ped);
    }

    public PedidoDto update(PedidoDto ped){
        return pedidoService.update(ped);
    }

    public void delete(Integer id){
        pedidoService.delete(id);
    }
}
