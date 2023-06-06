package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;


import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.PedidoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.PedidoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/pedido/")
public class PedidoResource {


    @Autowired
    private PedidoFacadeImpl pedidoFacade;

    @GetMapping("/all")
    public List<PedidoDto> findAll(){
        return pedidoFacade.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDto findById(@PathVariable Integer id){
        return pedidoFacade.findById(id);
    }

    @PostMapping("/create")
    public PedidoDto create(@RequestBody PedidoDto end){
        return pedidoFacade.create(end);
    }

    @PutMapping("/update")
    public PedidoDto update(@RequestBody PedidoDto end){
        return pedidoFacade.update(end);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        pedidoFacade.delete(id);
    }
}
