package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;


import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

import java.util.List;

public interface ProdutoFacade {

    List<ProdutoDto> findall();

    ProdutoDto findById(Integer id);

    ProdutoDto create(ProdutoDto prod) throws MyRunTimeException;

    ProdutoDto update(ProdutoDto prod) throws MyRunTimeException;

    void delete(Integer id);
}
