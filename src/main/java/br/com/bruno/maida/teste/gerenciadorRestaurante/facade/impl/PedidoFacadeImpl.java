package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoFacadeImpl{

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
