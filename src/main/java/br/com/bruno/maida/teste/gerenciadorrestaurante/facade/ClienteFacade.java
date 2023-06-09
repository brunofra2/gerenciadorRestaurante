package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface ClienteFacade {
    List<ClienteDto> findAll(Integer page,Integer pageSize);
    ClienteDto findById(Integer id);

    ClienteDto create(ClienteDto cli) throws Exception;

    ClienteDto update(ClienteDto cli) throws Exception;

}
