package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.ProdutoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public List<Produto> findall(Integer page,Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        return produtoRepository.buscarTodos(pageRequest);
    }

    @Override
    public Produto findById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public ProdutoDto create(ProdutoDto prod) throws MyRunTimeException {
        if (prod == null) throw new RequiredObjectIsNullException();
        var entity = ProdutoMapper.convertDtoToModel(prod);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

    @Override
    public ProdutoDto update(ProdutoDto prod) throws MyRunTimeException {
        if (prod == null) throw new RequiredObjectIsNullException();
        var entity = ProdutoMapper.convertDtoToModel(prod);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

}
