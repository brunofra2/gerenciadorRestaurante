package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.ClienteFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/cliente/")
public class  ClienteResource  {

    @Autowired
    private ClienteFacadeImpl clienteFacade;

    @GetMapping("/all")
    public List<ClienteDto> findAll(){
        return clienteFacade.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDto findById(@PathVariable Integer id){
        return clienteFacade.findById(id);
    }

    @PostMapping("/create")
    public ClienteDto create(@RequestBody ClienteDto cli){
        return clienteFacade.create(cli);
    }

    @PutMapping("/update")
    public ClienteDto update(@RequestBody ClienteDto cli){
        return clienteFacade.update(cli);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        clienteFacade.delete(id);
    }
}

