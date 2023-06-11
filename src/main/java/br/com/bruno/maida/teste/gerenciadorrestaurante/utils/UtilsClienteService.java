package br.com.bruno.maida.teste.gerenciadorrestaurante.utils;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;

public class UtilsClienteService {

    /** realiza a verificação das regras
     *  para realização de adição ou ateração do cliente**/
    public static ClienteDto verificacoesdeCampos(
            UsuarioRepository usuarioRepository, ClienteDto cli,
            ClienteRepository clienteRepository,String acao) throws Exception {
        var usuario = usuarioRepository.findUsuario(Utils.captUsuarioLogado());
        if(usuario.getTypeUser() == TipoUsuario.GESTOR){
            throw new MyRunTimeException("Este usuario não pode ser cliente");
        }
        if (cli == null) throw new RequiredObjectIsNullException();


        cli.setFkUsuario(new UsuarioDto().builder().id(usuario.getId()).build());

        return cli;
    }

    /** verifica o usuario logado
     * e adiciona o a id do seu cliente
     * para realização da alteração**/
    public static ClienteDto verificacoesdeCamposUpdate(
            UsuarioRepository usuarioRepository, ClienteDto cli,
            ClienteRepository clienteRepository) throws Exception {
        var cliente = clienteRepository.verifyClienteLogado(Utils.captUsuarioLogado());
        cli.setId(cliente.getId());
        return verificacoesdeCampos(usuarioRepository,cli,clienteRepository,"update");
    }
}