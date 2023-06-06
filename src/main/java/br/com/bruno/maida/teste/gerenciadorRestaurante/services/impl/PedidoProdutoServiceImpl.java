package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.PedidoProdutoMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.PedidoProduto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.PedidoProdutoRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProdutoServiceImpl implements PedidoProdutoService {

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    @Override
    public List<PedidoProduto> findAll() {
        return pedidoProdutoRepository.findAll();
    }

    @Override
    public PedidoProduto findById(Integer id) {
        return pedidoProdutoRepository.findById(id).get();
    }

    @Override
    public PedidoProdutoDto create(PedidoProdutoDto pedprod) {
        if (pedprod == null) throw new RequiredObjectIsNullException();

        var entity = PedidoProdutoMapper.convertDtoToModel(pedprod);
        var vo =  PedidoProdutoMapper.convertModelToDto(pedidoProdutoRepository.save(entity));
        return vo;
    }

    @Override
    public PedidoProdutoDto update(PedidoProdutoDto pedprod) {
        var entity = PedidoProdutoMapper.convertDtoToModel(pedprod);
        var vo =  PedidoProdutoMapper.convertModelToDto(pedidoProdutoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        pedidoProdutoRepository.delete(pedidoProdutoRepository.findById(id).get());
    }
}
