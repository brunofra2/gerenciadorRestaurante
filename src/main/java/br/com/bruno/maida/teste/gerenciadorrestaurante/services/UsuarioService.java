package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;

public interface UsuarioService {

    Usuario findUsuario(LoginDto login);

    Usuario findById(Integer id);

    UsuarioDto create(UsuarioDto user) throws Exception;

    UsuarioDto update(UsuarioDto user) throws Exception;

    void delete(Integer id);

}
