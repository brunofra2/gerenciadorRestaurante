package br.com.bruno.maida.teste.gerenciadorrestaurante.facade;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;

public interface UsuarioFacade {

    UsuarioDto findUsuario(LoginDto login);

    UsuarioDto findById(Integer id);

    UsuarioDto create(UsuarioDto user) throws Exception;

    UsuarioDto update(UsuarioDto user) throws Exception;

}
