package br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;

public class ClienteMapper {

    public static ClienteDto convertModelToDto(Cliente origin){
        UsuarioDto us = new UsuarioDto();
        us.setId(origin.getFkUsuario().getId());
        ClienteDto dto = new ClienteDto();
        dto.setId(origin.getId());
        dto.setName(origin.getName());
        dto.setTelefone(origin.getTelefone());
        dto.setCpfCnpj(origin.getCpfCnpj());
        dto.setFkUsuario(us);
        return  dto;
    }

    public static Cliente convertDtoToModel(ClienteDto origin){
        Usuario us = new Usuario();
        us.setId(origin.getFkUsuario().getId());
        Cliente model = new Cliente();
        model.setId(origin.getId());
        model.setName(origin.getName());
        model.setTelefone(origin.getTelefone());
        model.setCpfCnpj(origin.getCpfCnpj());
        model.setFkUsuario(us);
        return model;
    }
}
