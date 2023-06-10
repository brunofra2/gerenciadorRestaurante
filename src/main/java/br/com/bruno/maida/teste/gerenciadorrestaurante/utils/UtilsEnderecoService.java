package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.EnderecoRepository;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;

public class UtilsEnderecoService {

    public static EnderecoDto criarEndereco(EnderecoDto endereco, Cliente usuarioLogado){

        if (endereco == null) throw new RequiredObjectIsNullException();

        endereco.setFkCliente(new ClienteDto().builder()
                .id(usuarioLogado.getId())
                .fkUsuario(
                        new UsuarioDto().builder()
                                .id(usuarioLogado.getFkUsuario().getId()).build()
                ).build());
        return endereco;
    }
}
