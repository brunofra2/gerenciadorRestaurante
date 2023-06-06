package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoFacadeImpl{

    @Autowired
    private EnderecoService enderecoService;

    public List<EnderecoDto> findAll(){
        return DozerMapper.parseListObjects(enderecoService.findAll(),EnderecoDto.class);
    }

    public List<EnderecoDto> findById(Integer id){
        var endereco  = enderecoService.findById(id);
         List<EnderecoDto> enderecoDto = DozerMapper.parseListObjects(endereco,EnderecoDto.class);
        return  enderecoDto;
    }

    public EnderecoDto create(EnderecoDto end){
        return enderecoService.create(end);
    }

    public EnderecoDto update(EnderecoDto end){
        return enderecoService.update(end);
    }

    public void delete(Integer id){
        enderecoService.delete(id);
    }
}
