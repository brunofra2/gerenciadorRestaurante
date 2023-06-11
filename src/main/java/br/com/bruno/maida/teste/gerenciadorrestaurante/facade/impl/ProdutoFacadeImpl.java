package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.ProdutoFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoFacadeImpl implements ProdutoFacade {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public List<ProdutoDto> findall(Integer page,Integer pageSize) {
        return DozerMapper.parseListObjects(produtoService.findall(page,pageSize),ProdutoDto.class);
    }
    @Override
    public ProdutoDto findById(Integer id) {
        var pagamento = produtoService.findById(id);
        var pagamentoDto = DozerMapper.parseObject(pagamento, ProdutoDto.class);
        return pagamentoDto;
    }

    @Override
    public ProdutoDto create(ProdutoDto prod) throws MyRunTimeException {
        return produtoService.create(prod);
    }

    @Override
    public ProdutoDto update(ProdutoDto prod) throws MyRunTimeException {
        return produtoService.update(prod);
    }

}
