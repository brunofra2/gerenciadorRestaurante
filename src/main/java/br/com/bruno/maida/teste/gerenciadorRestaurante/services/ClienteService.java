package br.com.bruno.maida.teste.gerenciadorRestaurante.services;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(Integer id);

    ClienteDto create(ClienteDto cli);

    ClienteDto update(ClienteDto cli);

    void delete(Integer id);
}
