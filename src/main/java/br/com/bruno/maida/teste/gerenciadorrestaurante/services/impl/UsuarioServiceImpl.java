package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.UsuarioService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.UsuarioMapper;
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
        return usuarioRepository.findUsuario(login.email());
    }

    @Override
    public Usuario findById(Integer id){
        return usuarioRepository.findById(id).get();
    }

    @Override
    public UsuarioDto create(UsuarioDto user) throws MyRunTimeException {
        if (user == null) throw new RequiredObjectIsNullException();
        Usuario existUsuario = usuarioRepository.findUsuario(user.getEmail());
        if(existUsuario != null){
            throw  new MyRunTimeException("usuario já esta cadastrado");
        }
        if (user.getTypeUser() == TipoUsuarioDto.GESTOR){
            var verfifyGestor = usuarioRepository.findCount();
            if(verfifyGestor >= 1){
                throw  new MyRunTimeException("Já existe um Gestor para este estabelecimento");
            }
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        var entity = UsuarioMapper.convertDtoToModel(user);
        return   UsuarioMapper.convertModelToDto(usuarioRepository.save(entity));


    }

    @Override
    public UsuarioDto update(UsuarioDto user) throws Exception{

        if (user == null) throw new RequiredObjectIsNullException();


        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return  UsuarioMapper.convertModelToDto(
                usuarioRepository.save(
                        UsuarioMapper.convertDtoToModel(user)
                ));

    }

    @Override
    public void delete(Integer id) throws MyRunTimeException {
        var usuario = usuarioRepository.findById(id).get();
        if(usuario.getTypeUser() == TipoUsuario.GESTOR){
            throw new MyRunTimeException("este usuario não pode ser excluido, por ser um gestor");
        }else{
            usuarioRepository.delete(usuario);
        }
    }

}
