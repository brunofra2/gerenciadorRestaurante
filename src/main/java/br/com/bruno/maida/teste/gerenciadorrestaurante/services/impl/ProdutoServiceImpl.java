package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.ProdutoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Produto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ProdutoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilsProdutoService;
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
    public ProdutoDto create(ProdutoDto prod) throws MyRunTimeException {

        if (prod == null) throw new RequiredObjectIsNullException();
        UtilsProdutoService.verificarCampos(prod);
        var entity = ProdutoMapper.convertDtoToModel(prod);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

    @Override
    public ProdutoDto update(ProdutoDto prod) throws MyRunTimeException {
        if (prod == null) throw new RequiredObjectIsNullException();
        UtilsProdutoService.verificarCampos(prod);
        var entity = ProdutoMapper.convertDtoToModel(prod);
        var vo =  ProdutoMapper.convertModelToDto(produtoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        produtoRepository.delete(produtoRepository.findById(id).get());
    }
}
