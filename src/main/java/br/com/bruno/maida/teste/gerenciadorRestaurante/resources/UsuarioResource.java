package br.com.bruno.maida.teste.gerenciadorRestaurante.resources;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl.UsuarioFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restaurante/user/")
public class UsuarioResource {

    @Autowired
    private UsuarioFacadeImpl usuarioFacadeImpl;

    @GetMapping("/login")
    public UsuarioDto findUsuario(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "senha") String senha){
        return usuarioFacadeImpl.findUsuario(email,senha);
    }

    @GetMapping("/{id}")
    public UsuarioDto findById(@PathVariable Integer id){
        return usuarioFacadeImpl.findById(id);
    }


    @PostMapping("/create")
    public UsuarioDto create(@RequestBody UsuarioDto user){
        return usuarioFacadeImpl.create(user);
    }

    @PutMapping("/update")
    public UsuarioDto update(@RequestBody UsuarioDto user){
        return usuarioFacadeImpl.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        usuarioFacadeImpl.delete(id);
    }
}
