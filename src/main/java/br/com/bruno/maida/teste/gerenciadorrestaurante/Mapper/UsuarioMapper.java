package br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;

public class UsuarioMapper {

    public static UsuarioDto convertModelToDto (Usuario origin){
        return new UsuarioDto().builder()
                .id(origin.getId())
                .email(origin.getEmail())
                .password(origin.getPassword())
                .name(origin.getName())
                .typeUser(TipoUsuarioDto.valueOf(origin.getTypeUser().toString())).build();
    }

    public static Usuario convertDtoToModel(UsuarioDto origin){

        return new Usuario().builder()
                .id(origin.getId())
                .email(origin.getEmail())
                .password(origin.getPassword())
                .name(origin.getName())
                .typeUser(TipoUsuario.valueOf(origin.getTypeUser().toString())).build();
    }
}
