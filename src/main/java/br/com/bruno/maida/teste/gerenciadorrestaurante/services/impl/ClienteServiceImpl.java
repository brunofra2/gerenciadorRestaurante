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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Cliente> findAll(Integer page,Integer pageSize) {
        PageRequest pageRequest =PageRequest.of(page - 1,pageSize);
        return clienteRepository.buscarTodos(pageRequest);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public ClienteDto create(ClienteDto cli) throws Exception {
        UtilsClienteService.verificacoesdeCampos(usuarioRepository,cli,clienteRepository,null);
        var entity = ClienteMapper.convertDtoToModel(cli);
        var vo =  ClienteMapper.convertModelToDto(clienteRepository.save(entity));
        return vo;
    }

    @Override
    public ClienteDto update(ClienteDto cli) throws Exception {

        UtilsClienteService.verificacoesdeCamposUpdate(usuarioRepository,cli,clienteRepository);
        var entity = ClienteMapper.convertDtoToModel(cli);
        var vo =  ClienteMapper.convertModelToDto(clienteRepository.save(entity));
        return vo;
    }

}
