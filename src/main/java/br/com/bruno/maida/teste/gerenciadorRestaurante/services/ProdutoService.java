package br.com.bruno.maida.teste.gerenciadorRestaurante.services;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findall();

    Produto findById(Integer id);

    ProdutoDto create(ProdutoDto pag);

    ProdutoDto update(ProdutoDto pag);

    void delete(Integer id);
}
