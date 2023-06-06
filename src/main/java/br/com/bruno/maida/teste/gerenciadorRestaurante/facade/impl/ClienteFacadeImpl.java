package br.com.bruno.maida.teste.gerenciadorRestaurante.facade.impl;

import br.com.bruno.maida.teste.gerenciadorRestaurante.Mapper.DozerMapper;
import br.com.bruno.maida.teste.gerenciadorRestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorRestaurante.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacadeImpl {

    @Autowired
    private ClienteService clienteService;

    public List<ClienteDto> findAll(){
       return DozerMapper.parseListObjects(clienteService.findAll(),ClienteDto.class);
    }
    public ClienteDto findById(Integer id){
        var cliente  = clienteService.findById(id);
        var clienteDto = DozerMapper.parseObject(cliente,ClienteDto.class);
        return  clienteDto;
    }

    public ClienteDto create(ClienteDto cli){
        return clienteService.create(cli);
    }

    public ClienteDto update(ClienteDto cli){
        return clienteService.update(cli);
    }

    public void delete(Integer id){
        clienteService.delete(id);
    }

}
