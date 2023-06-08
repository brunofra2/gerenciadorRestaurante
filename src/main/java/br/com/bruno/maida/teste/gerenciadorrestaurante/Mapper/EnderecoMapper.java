package br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;

public class EnderecoMapper {

    public static EnderecoDto convertoModelToDto(Endereco origin){
        ClienteDto cli = new ClienteDto();
        cli.setId(origin.getFkCliente().getId());
        EnderecoDto dto = new EnderecoDto();
                dto.setId(origin.getId());
                dto.setBairro(origin.getBairro());
                dto.setCep(origin.getCep());
                dto.setCidade(origin.getCidade());
                dto.setEstado(origin.getEstado());
                dto.setNumero(origin.getNumero());
                dto.setPais(origin.getPais());
                dto.setRua(origin.getRua());
                dto.setFkCliente(cli);
        return dto;
    }

    public static Endereco convertoDtoToModel(EnderecoDto origin){
        Cliente cli = new Cliente();
        cli.setId(origin.getFkCliente().getId());
        Endereco model = new Endereco();
        model.setId(origin.getId());
        model.setBairro(origin.getBairro());
        model.setCep(origin.getCep());
        model.setCidade(origin.getCidade());
        model.setEstado(origin.getEstado());
        model.setNumero(origin.getNumero());
        model.setPais(origin.getPais());
        model.setRua(origin.getRua());
        model.setFkCliente(cli);
        return model;
    }
}
