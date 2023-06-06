package br.com.bruno.maida.teste.gerenciadorRestaurante.services;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Usuario;

public interface UsuarioService {

    Usuario findUsuario(String email, String senha);

    Usuario findById(Integer id);

    UsuarioDto create(UsuarioDto user);

    UsuarioDto update(UsuarioDto user);

    void delete(Integer id);

}
