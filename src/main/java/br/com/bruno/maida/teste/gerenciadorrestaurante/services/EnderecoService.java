package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> findAll();

    Endereco findById(Integer id);

    EnderecoDto create(EnderecoDto end);

    EnderecoDto update(EnderecoDto end);

    String delete(Integer id);
}
