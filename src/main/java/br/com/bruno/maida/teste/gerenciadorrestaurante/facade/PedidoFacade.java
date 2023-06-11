package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface PedidoFacade {

    List<PedidoDto> findAll();
    List<PedidoDto> findfinally();
    PedidoDto findById(Integer id) throws MyRunTimeException;

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped) throws MyRunTimeException;

    void delete(Integer id);
}
