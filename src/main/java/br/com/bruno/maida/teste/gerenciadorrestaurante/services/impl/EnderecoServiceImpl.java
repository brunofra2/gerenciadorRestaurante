package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.EnderecoService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.EnderecoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.EnderecoMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findUsuarioEmail(UtilServices.captUsuarioLogado());
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findUsuarioEmailById(UtilServices.captUsuarioLogado(),id);
    }

    @Override
    public EnderecoDto create(EnderecoDto end) {
        if (end == null) throw new RequiredObjectIsNullException();

        var entity = EnderecoMapper.convertoDtoToModel(end);
        var vo =  EnderecoMapper.convertoModelToDto(enderecoRepository.save(entity));
        return vo;
    }

    @Override
    public EnderecoDto update(EnderecoDto end) {
        if (end == null) throw new RequiredObjectIsNullException();

        var entity = EnderecoMapper.convertoDtoToModel(end);
        var vo =  EnderecoMapper.convertoModelToDto(enderecoRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {

        enderecoRepository.delete(enderecoRepository.findById(id).get());
    }
}
