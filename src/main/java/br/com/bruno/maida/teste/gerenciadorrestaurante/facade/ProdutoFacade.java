package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;


import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;

import java.util.List;

public interface ProdutoFacade {

    List<ProdutoDto> findall();

    ProdutoDto findById(Integer id);

    ProdutoDto create(ProdutoDto prod);

    ProdutoDto update(ProdutoDto prod);

    void delete(Integer id);
}
