package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface EnderecoFacade {

    List<EnderecoDto> findAll(Integer page,Integer pageSize);

    EnderecoDto findById(Integer id) throws MyRunTimeException;

    EnderecoDto create(EnderecoDto end);

    EnderecoDto update(EnderecoDto end);

    String delete(Integer id);
}
