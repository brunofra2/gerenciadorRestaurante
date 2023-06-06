package br.com.bruno.maida.teste.gerenciadorRestaurante.services;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Pedido;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;

import java.util.List;

public interface PedidoService {

    List<Pedido> findAll();

    Pedido findById(Integer id);

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped);

    void delete(Integer id);
}
