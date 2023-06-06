package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;


import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.PedidoProdutoFacadeImpl;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/pedidoproduto")
public class PedidoProdutoResource {

    @Autowired
    private PedidoProdutoFacadeImpl pedidoProdutoFacade;

    @GetMapping("/all")
    public List<PedidoProdutoDto> findAll(){
        return pedidoProdutoFacade.findAll();
    }

    @GetMapping("/{id}")
    public PedidoProdutoDto findById(@PathVariable Integer id){
        return pedidoProdutoFacade.findById(id);
    }

    @PostMapping("/create")
    public PedidoProdutoDto create(@RequestBody PedidoProdutoDto pedprod){
        return pedidoProdutoFacade.create(pedprod);
    }

    @PutMapping("/update")
    public PedidoProdutoDto update(@RequestBody PedidoProdutoDto pedprod){
        return pedidoProdutoFacade.update(pedprod);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        pedidoProdutoFacade.delete(id);
    }
}
