package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> findAll(Integer page,Integer pageSize);

    Endereco findById(Integer id) throws MyRunTimeException;

    EnderecoDto create(EnderecoDto end);

    EnderecoDto update(EnderecoDto end);

    String delete(Integer id);

}
