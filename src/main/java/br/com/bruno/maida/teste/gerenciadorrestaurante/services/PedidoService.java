package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;

import java.util.List;

public interface PedidoService {

    List<Pedido> findAll();

    Pedido findById(Integer id);

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped);

    void delete(Integer id);
}
