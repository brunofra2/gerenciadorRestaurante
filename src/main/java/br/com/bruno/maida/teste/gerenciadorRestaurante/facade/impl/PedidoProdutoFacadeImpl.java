package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl.PedidoProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoProdutoFacadeImpl {

    @Autowired
    private PedidoProdutoServiceImpl pedidoProdutoService;

    public List<PedidoProdutoDto> findAll() {
        return DozerMapper.parseListObjects(pedidoProdutoService.findAll(),PedidoProdutoDto.class);
    }

    public PedidoProdutoDto findById(Integer id) {
        var pagamento = pedidoProdutoService.findById(id);
        var pagamentoDto = DozerMapper.parseObject(pagamento, PedidoProdutoDto.class);
        return pagamentoDto;
    }

    public PedidoProdutoDto create(PedidoProdutoDto pag) {
        return pedidoProdutoService.create(pag);
    }

    public PedidoProdutoDto update(PedidoProdutoDto pag) {
        return pedidoProdutoService.update(pag);
    }


    public void delete(Integer id) {
        pedidoProdutoService.delete(id);
    }
}
