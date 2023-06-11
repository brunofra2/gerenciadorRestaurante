package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface PedidoFacade {

    List<PedidoDto> findAll();

    PedidoDto findById(Integer id);

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped) throws MyRunTimeException;

    void delete(Integer id);
}
