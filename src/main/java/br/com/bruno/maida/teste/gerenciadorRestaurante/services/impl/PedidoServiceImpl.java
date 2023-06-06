package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.services.PedidoService;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.PedidoRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public PedidoDto create(PedidoDto ped) {
        if (ped == null) throw new RequiredObjectIsNullException();

        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        return vo;
    }

    @Override
    public PedidoDto update(PedidoDto ped) {
        if (ped == null) throw new RequiredObjectIsNullException();

        var entity = PedidoMapper.convertDtoToModel(ped);
        var vo =  PedidoMapper.convertModelToDto(pedidoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        pedidoRepository.delete(pedidoRepository.findById(id).get());
    }
}
