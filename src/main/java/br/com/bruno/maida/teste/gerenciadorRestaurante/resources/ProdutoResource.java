package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ProdutoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.ProdutoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurante/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoFacadeImpl produtoFacade;

    @GetMapping("/all")
    public List<ProdutoDto> findall(){
        return produtoFacade.findall();
    }

    @GetMapping("by/{id}")
    public List<ProdutoDto>  findById(@PathVariable Integer id){
        List<ProdutoDto> lista = new ArrayList<>();
        lista.add(produtoFacade.findById(id));
        return lista;
    }

    @PostMapping("/create")
    public ProdutoDto create(@RequestBody ProdutoDto pag){
        return produtoFacade.create(pag);
    }

    @PutMapping("/update")
    public ProdutoDto update(@RequestBody ProdutoDto pag){
        return produtoFacade.update(pag);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        produtoFacade.delete(id);
    }
}
