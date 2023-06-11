package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.EnderecoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.EnderecoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.EnderecoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilsEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Endereco> findAll(Integer page, Integer pageSize) {

        var usuarioLogado = usuarioRepository.findUsuario(captUsuarioLogado());
        PageRequest pageRequest =PageRequest.of(page - 1,pageSize);
        if(usuarioLogado.getTypeUser() == TipoUsuario.GESTOR){
            return enderecoRepository.buscarTodos(pageRequest);
        }else{

            return enderecoRepository.findUsuarioEmail(Utils.captUsuarioLogado());
        }
    }

    @Override
    public Endereco findById(Integer id,Integer page, Integer pageSize) throws MyRunTimeException {
        var usuarioLogado = usuarioRepository.findUsuario(captUsuarioLogado());
        PageRequest pageRequest =PageRequest.of(page - 1,pageSize);
        if(usuarioLogado.getTypeUser() == TipoUsuario.GESTOR){
            return enderecoRepository.findById(id).get();
        }else{

            var endereco = enderecoRepository.findUsuarioEmailById(Utils.captUsuarioLogado(),id,pageRequest);
            if(endereco == null){
                throw new MyRunTimeException("você não tem permissão para acessar este endereço");
            }else {
                return endereco;
            }
        }
    }

    @Override
    public EnderecoDto create(EnderecoDto end) {

        var usuarioLogado = clienteRepository.verifyClienteLogado(captUsuarioLogado());

        UtilsEnderecoService.criarEndereco(end,usuarioLogado);

        var entity = EnderecoMapper.convertoDtoToModel(end);
        var vo =  EnderecoMapper.convertoModelToDto(enderecoRepository.save(entity));
        return vo;
    }

    @Override
    public EnderecoDto update(EnderecoDto end) {
        if (end == null) throw new RequiredObjectIsNullException();
        var usuarioLogado = clienteRepository.verifyClienteLogado(captUsuarioLogado());

        UtilsEnderecoService.criarEndereco(end,usuarioLogado);

        var entity = EnderecoMapper.convertoDtoToModel(end);
        var vo =  EnderecoMapper.convertoModelToDto(enderecoRepository.save(entity));
        return vo;
    }

    @Override
    public String delete(Integer id) {
        if(Utils.captUsuarioLogado().equals(enderecoRepository.findById(id).get())){
            enderecoRepository.delete(enderecoRepository.findById(id).get());
            return "endereço removido com sucesso";
        }else{
            return "ação não autorizada";
        }

    }
}
