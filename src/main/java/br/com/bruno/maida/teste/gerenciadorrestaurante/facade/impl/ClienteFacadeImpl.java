package br.com.bruno.maida.teste.gerenciadorrestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.facade.ClienteFacade;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacadeImpl implements ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Override
    public List<ClienteDto> findAll(Integer page,Integer pageSize){
       return DozerMapper.parseListObjects(clienteService.findAll(page,pageSize),ClienteDto.class);
    }
    @Override
    public ClienteDto findById(Integer id){
        var cliente  = clienteService.findById(id);
        var clienteDto = DozerMapper.parseObject(cliente,ClienteDto.class);
        return  clienteDto;
    }

    @Override
    public ClienteDto create(ClienteDto cli) throws Exception {
        return clienteService.create(cli);
    }

    @Override
    public ClienteDto update(ClienteDto cli) throws Exception {
        return clienteService.update(cli);
    }


}
