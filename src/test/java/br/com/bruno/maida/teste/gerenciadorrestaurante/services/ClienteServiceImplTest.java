package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.UtilsTest.Constantes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.ClienteDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.ClienteRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.ClienteServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("teste do service - Cliente Service")
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private PageRequest pageRequestMock;

    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;


    @Test
    @DisplayName("Cliente - deve listar todas as informações")
    public void deveListarosClientes() throws Exception{
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Cliente> clientes = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(clienteRepository.buscarTodos(pageRequest))
                .thenReturn(clientes);
        clienteServiceImpl.findAll(page,pageSize);
        Mockito.verify(clienteRepository).buscarTodos(pageRequest);
    }

    @Test
    @DisplayName("Cliente - Buscar cliente por id")
    public void deveBuscarClientePorId() throws Exception{
        Integer id = Constantes.ID;
        Mockito.when(clienteRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(criacao()));
        clienteServiceImpl.findById(Mockito.any());
        Mockito.verify(clienteRepository).findById(Mockito.any());
    }

    @Test
    public void testarCriacao() throws Exception {

        Mockito.when(clienteRepository.save(Mockito.any()))
                .thenReturn(criacao());
        clienteServiceImpl.create(criacaoDto());
        Mockito.verify(clienteRepository).save(Mockito.any());

    }

    @Test
    public void testarAlteracao() throws Exception {

        Mockito.when(clienteRepository.save(Mockito.any()))
                .thenReturn(criacao());
        clienteServiceImpl.update(criacaoDto());
        Mockito.verify(clienteRepository).save(Mockito.any());

    }



    private Cliente criacao(){
        return new Cliente().builder()
                .id(5)
                .name("Nome teste 1")
                .cpfCnpj("Documento teste 1")
                .telefone("telefone teste 1")
                .nascimento("nascimento 1")
                .build();
    }

    private ClienteDto criacaoDto(){
        return new ClienteDto().builder()
                .id(5)
                .name("Nome teste 1")
                .cpfCnpj("Documento teste 1")
                .telefone("telefone teste 1")
                .nascimento("nascimento 1")
                .build();
    }

}
