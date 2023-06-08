package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;

import java.util.List;

public interface EnderecoFacade {

    List<EnderecoDto> findAll();

    List<EnderecoDto> findById(Integer id);

    EnderecoDto create(EnderecoDto end);

    EnderecoDto update(EnderecoDto end);

    void delete(Integer id);
}
