package br.com.bruno.maida.teste.gerenciadorrestaurante.services;


import br.com.bruno.maida.teste.gerenciadorrestaurante.UtilsTest.Constantes;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.EnderecoDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Cliente;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Endereco;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.EnderecoRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.EnderecoServiceImpl;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.TokenService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Teste do service - Endereço Service")
public class EnderecoServiceImplTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    PageRequest pageRequest;

    @InjectMocks
    private TokenService tokenService;
    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @Test
    @DisplayName("Cliente - deve listar todas as informações")
    public void deveListarosEnderecos() throws Exception{
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Endereco> enderecos = List.of(criacao());
        String token = tokenService.gerarToken(new Usuario().builder()
                        .id(1)
                        .email("adriele@gmail.com")
                        .password("123")
                        .name("adriele")
                        .typeUser(TipoUsuario.CLIENTE)
                .build());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(enderecoRepository.buscarTodos(pageRequest))
                .thenReturn(enderecos);
        enderecoService.findAll(page,pageSize);
        Mockito.verify(enderecoRepository).buscarTodos(pageRequest);
    }


    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosEnderecoPorUsuario() throws Exception{
        Integer page = Constantes.PAGE;
        Integer pageSize = Constantes.PAGE_SIZE;
        List<Endereco> enderecos = List.of(criacao());
        PageRequest pageRequest = PageRequest.of(page -1, pageSize);
        Mockito.when(enderecoRepository.findUsuarioEmail(Utils.captUsuarioLogado(),pageRequest))
                .thenReturn(enderecos);
        enderecoService.findAll(page,pageSize);
        Mockito.verify(enderecoRepository).findUsuarioEmail(Utils.captUsuarioLogado(),pageRequest);
    }

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosEnderecoPorId() throws MyRunTimeException {
        Mockito.when(enderecoRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(criacao()));
        enderecoService.findById(Mockito.any());
        Mockito.verify(enderecoRepository).findById(Mockito.any());
    }

    @Test
    @DisplayName("Cliente - deve listar todas as informações por usuario")
    public void deveListarosEnderecoPorIdUsuario() throws MyRunTimeException {
        Mockito.when(enderecoRepository.findUsuarioEmailById(Mockito.any(),Mockito.any()))
                .thenReturn(criacao());
        enderecoService.findById(Mockito.any());
        Mockito.verify(enderecoRepository).findUsuarioEmailById(Mockito.any(),Mockito.any());
    }

    @Test
    public void testarCriacao() throws Exception {

        Mockito.when(enderecoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        enderecoService.create(criacaoDto());
        Mockito.verify(enderecoRepository).save(Mockito.any());

    }

    @Test
    public void testarAlteracao() throws Exception {

        Mockito.when(enderecoRepository.save(Mockito.any()))
                .thenReturn(criacao());
        enderecoService.update(criacaoDto());
        Mockito.verify(enderecoRepository).save(Mockito.any());

    }
    private Endereco criacao(){
        return  new Endereco().builder()
                .id(1)
                .bairro("teste")
                .cep("teste")
                .rua("teste")
                .pais("teste")
                .numero("teste")
                .estado("teste")
                .cidade("teste")
                .build();
    }
    private EnderecoDto criacaoDto(){
        return  new EnderecoDto().builder()
                .id(1)
                .bairro("teste")
                .cep("teste")
                .rua("teste")
                .pais("teste")
                .numero("teste")
                .estado("teste")
                .cidade("teste")
                .build();
    }
}
