package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoFacadeImpl {

    @Autowired
    private ProdutoService produtoService;

    public List<ProdutoDto> findall() {
        return DozerMapper.parseListObjects(produtoService.findall(),ProdutoDto.class);
    }

    public ProdutoDto findById(Integer id) {
        var pagamento = produtoService.findById(id);
        var pagamentoDto = DozerMapper.parseObject(pagamento, ProdutoDto.class);
        return pagamentoDto;
    }

    public ProdutoDto create(ProdutoDto prod) {
        return produtoService.create(prod);
    }

    public ProdutoDto update(ProdutoDto prod) {
        return produtoService.update(prod);
    }


    public void delete(Integer id) {
        produtoService.delete(id);
    }
}
