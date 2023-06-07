package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.Exception;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.UsuarioService;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    @Override
    public Usuario findUsuario(LoginDto login){
        return usuarioRepository.findUsuario(login.getEmail());
    }

    @Override
    public Usuario findById(Integer id){
        var usuarioOptional = usuarioRepository.findById(id);
        var usuario = usuarioOptional.get();
        return usuario;
    }

    @Override
    public UsuarioDto create(UsuarioDto user) throws Exception {
            if (user == null) throw new RequiredObjectIsNullException();
            Usuario existUsuario = usuarioRepository.findUsuario(user.getEmail());
                    if(existUsuario != null){
                        throw  new Exception("usuario já esta cadastrado");
                    }
                    user.setPassword(passwordEncoder().encode(user.getPassword()));
            var entity = UsuarioMapper.convertDtoToModel(user);
            var vo =   UsuarioMapper.convertModelToDto(usuarioRepository.save(entity));
            return vo;

    }

    @Override
    public UsuarioDto update(UsuarioDto user) {

        if (user == null) throw new RequiredObjectIsNullException();

        var entity = UsuarioMapper.convertDtoToModel(user);
        var vo =   UsuarioMapper.convertModelToDto(usuarioRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id){
        usuarioRepository.delete(usuarioRepository.findById(id).get());
    }

}
