package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.ProdutoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public List<Produto> findall() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public ProdutoDto create(ProdutoDto pag) {
        if (pag == null) throw new RequiredObjectIsNullException();
        var entity = ProdutoMapper.convertDtoToModel(pag);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

    @Override
    public ProdutoDto update(ProdutoDto pag) {
        if (pag == null) throw new RequiredObjectIsNullException();
        var entity = ProdutoMapper.convertDtoToModel(pag);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        produtoRepository.delete(produtoRepository.findById(id).get());
    }
}
