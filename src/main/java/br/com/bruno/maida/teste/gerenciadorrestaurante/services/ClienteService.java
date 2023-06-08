package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Integer id);

    ClienteDto create(ClienteDto cli);

    ClienteDto update(ClienteDto cli);

    void delete(Integer id);
}
