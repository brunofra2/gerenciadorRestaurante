package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;


import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.EnderecoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/endereco/")
public class EnderecoResource {


    @Autowired
    private EnderecoFacadeImpl enderecoFacade;

    @GetMapping("/all")
    public List<EnderecoDto> findAll(){
        return enderecoFacade.findAll();
    }

    @GetMapping("/{id}")
    public List<EnderecoDto> findById(@PathVariable Integer id){
        return enderecoFacade.findById(id);
    }

    @PostMapping("/create")
    public EnderecoDto create(@RequestBody EnderecoDto end){
        return enderecoFacade.create(end);
    }

    @PutMapping("/update")
    public EnderecoDto update(@RequestBody EnderecoDto end){
        return enderecoFacade.update(end);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        enderecoFacade.delete(id);
    }
}
