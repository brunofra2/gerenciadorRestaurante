package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.EnderecoFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoFacadeImpl implements EnderecoFacade {

    @Autowired
    private EnderecoService enderecoService;
    @Override
    public List<EnderecoDto> findAll(Integer id,Integer page,Integer pageSize){
        return DozerMapper.parseListObjects(enderecoService.findAll(page,pageSize),EnderecoDto.class);
    }

    @Override
    public EnderecoDto findById(Integer id,Integer page, Integer pageSize) throws MyRunTimeException {
        var endereco  = enderecoService.findById(id,page,pageSize);
         return DozerMapper.parseObject(endereco,EnderecoDto.class);
    }

    @Override
    public EnderecoDto create(EnderecoDto end){
        return enderecoService.create(end);
    }

    @Override
    public EnderecoDto update(EnderecoDto end){
        return enderecoService.update(end);
    }

    @Override
    public String delete(Integer id){
       return enderecoService.delete(id);
    }
}
