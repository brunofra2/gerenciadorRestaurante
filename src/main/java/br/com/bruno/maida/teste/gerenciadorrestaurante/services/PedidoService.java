package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> findAll();

    public List<Pedido> findFinally();

    Pedido findById(Integer id) throws MyRunTimeException;

    PedidoDto create(PedidoDto ped);

    PedidoDto update(PedidoDto ped) throws MyRunTimeException;

    void delete(Integer id);
}
