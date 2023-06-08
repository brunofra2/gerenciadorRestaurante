package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.UsuarioFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFacadeImpl implements UsuarioFacade {

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

    public UsuarioDto update(UsuarioDto user) throws Exception{
        return usuarioService.update(user);
    }

    public void delete(Integer id){
        usuarioService.delete(id);
    }

}
