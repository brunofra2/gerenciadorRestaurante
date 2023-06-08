package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;

import java.util.List;

public interface PedidoFacade {

    List<PedidoDto> findAll();

    PedidoDto findById(Integer id);

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped);

    void delete(Integer id);
}
