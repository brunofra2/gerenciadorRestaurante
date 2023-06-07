package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFacadeImpl{

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioDto findUsuario(LoginDto login){
        return DozerMapper.parseObject(usuarioService.findUsuario(login),UsuarioDto.class);
    }
    public UsuarioDto findById(Integer id){
        var usuario  = usuarioService.findById(id);
        var usuarioDto = DozerMapper.parseObject(usuario,UsuarioDto.class);
        return  usuarioDto;
    }

    public UsuarioDto create(UsuarioDto user) throws Exception{
        return usuarioService.create(user);
    }

    public UsuarioDto update(UsuarioDto user){
        return usuarioService.update(user);
    }

    public void delete(Integer id){
        usuarioService.delete(id);
    }

}
