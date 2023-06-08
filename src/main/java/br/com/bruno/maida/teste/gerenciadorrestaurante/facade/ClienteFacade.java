package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;

import java.util.List;

public interface ClienteFacade {
    List<ClienteDto> findAll();
    ClienteDto findById(Integer id);

    ClienteDto create(ClienteDto cli);

    ClienteDto update(ClienteDto cli);

    void delete(Integer id);
}
