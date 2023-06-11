package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface PedidoFacade {

    List<PedidoDto> findAll(Integer page, Integer pageSize);
    List<PedidoDto> findfinally(Integer page, Integer pageSize);
    PedidoDto findById(Integer id) throws MyRunTimeException;

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped) throws MyRunTimeException;

}
