package br.com.bruno.maida.teste.gerenciadorRestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.EnderecoService;
import br.com.bruno.maida.teste.gerenciadorRestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorRestaurante.repositories.EnderecoRepository;
import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public List<Endereco> findById(Integer id) {
        return enderecoRepository.findByClient(id);
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
