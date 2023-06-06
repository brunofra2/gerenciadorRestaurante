package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.UsuarioService;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario findUsuario(String email,
                               String senha){
        return usuarioRepository.findUsuario(email,senha);
    }

    @Override
    public Usuario findById(Integer id){
        var usuarioOptional = usuarioRepository.findById(id);
        var usuario = usuarioOptional.get();
        return usuario;
    }

    @Override
    public UsuarioDto create(UsuarioDto user) {
            if (user == null) throw new RequiredObjectIsNullException();
        if(user.getTypeUser().equals(0)){
            var entidade =  usuarioRepository.findUsuario(user.getEmail(),user.getPassword());
            if(user.getTypeUser().equals(entidade.getTypeUser()))
                throw new RequiredObjectIsNullException();

        }
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
