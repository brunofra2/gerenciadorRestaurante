package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.EnderecoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.EnderecoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.EnderecoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilsEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils.captUsuarioLogado;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findUsuarioEmail(Utils.captUsuarioLogado());
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findUsuarioEmailById(Utils.captUsuarioLogado(),id);
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
