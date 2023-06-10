package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.RequiredObjectIsNullException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.ClienteService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.Mapper.ClienteMapper;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.UtilsClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public ClienteDto create(ClienteDto cli) throws MyRunTimeException {
        UtilsClienteService.verificaçõesdeCampos(usuarioRepository,cli,clienteRepository);
        var entity = ClienteMapper.convertDtoToModel(cli);
        var vo =  ClienteMapper.convertModelToDto(clienteRepository.save(entity));
        return vo;
    }

    @Override
    public ClienteDto update(ClienteDto cli) {
        if (cli == null) throw new RequiredObjectIsNullException();

        var entity = ClienteMapper.convertDtoToModel(cli);
        var vo =  ClienteMapper.convertModelToDto(clienteRepository.save(entity));
        return vo;
    }

    @Override
    public void delete(Integer id) {
        clienteRepository.delete(clienteRepository.findById(id).get());
    }
}
