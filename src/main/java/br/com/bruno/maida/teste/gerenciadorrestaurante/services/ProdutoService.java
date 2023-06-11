package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findall();

    Produto findById(Integer id);

    ProdutoDto create(ProdutoDto pag) throws MyRunTimeException;

    ProdutoDto update(ProdutoDto pag) throws MyRunTimeException;

    void delete(Integer id);
}
