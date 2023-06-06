package br.com.bruno.maida.teste.gerenciadorRestaurante.services;

import br.com.bruno.maida.teste.gerenciadorRestaurante.model.PedidoProduto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoProdutoDto;

import java.util.List;

public interface PedidoProdutoService {

    List<PedidoProduto> findAll();

    PedidoProduto findById(Integer id);

    PedidoProdutoDto create(PedidoProdutoDto pedprod);

    PedidoProdutoDto update(PedidoProdutoDto pedprod);

    void delete(Integer id);
}
