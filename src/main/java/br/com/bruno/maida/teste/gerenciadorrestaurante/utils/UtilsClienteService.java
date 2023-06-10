package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;

public class UtilsClienteService {

    public static ClienteDto verificaçõesdeCampos(
            UsuarioRepository usuarioRepository, ClienteDto cli,
            ClienteRepository clienteRepository,String acao) throws MyRunTimeException {
        var usuario = usuarioRepository.findUsuario(Utils.captUsuarioLogado());
        if(usuario.getTypeUser() == TipoUsuario.GESTOR){
            throw new MyRunTimeException("Este usuario não pode ser cliente");
        }
        if (cli == null) throw new RequiredObjectIsNullException();


        cli.setFkUsuario(new UsuarioDto().builder().id(usuario.getId()).build());

        if(acao == null){
            if(clienteRepository.verifyDuplicidade(cli.getFkUsuario().getId()) != null)
                throw new MyRunTimeException("usuario já é um cliente");
        }
        return cli;
    }

    public static ClienteDto verificaçõesdeCamposUpdate(
            UsuarioRepository usuarioRepository, ClienteDto cli,
            ClienteRepository clienteRepository) throws MyRunTimeException {
        var cliente = clienteRepository.verifyClienteLogado(Utils.captUsuarioLogado());
        cli.setId(cliente.getId());
        return verificaçõesdeCampos(usuarioRepository,cli,clienteRepository,"update");
    }
}