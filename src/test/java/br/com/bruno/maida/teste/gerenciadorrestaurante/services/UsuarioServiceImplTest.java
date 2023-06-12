package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.LoginDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.UsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.data.vo.enuns.TipoUsuarioDto;
import br.com.bruno.maida.teste.gerenciadorrestaurante.exceptions.MyRunTimeException;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.repositories.UsuarioRepository;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.UsuarioServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@DisplayName("Teste do service - Endereço Service")
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;


    @Test
    public void TestarLogin(){

        Mockito.when(usuarioRepository.findUsuario(Mockito.any()))
                .thenReturn(criacao());
        usuarioService.findUsuario(loginDto());
        Mockito.verify(usuarioRepository).findUsuario(Mockito.any());
    }

    @Test
    public void TestarTrazerPorId(){

        Mockito.when(usuarioRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(criacao()));
        usuarioService.findById(Mockito.any());
        Mockito.verify(usuarioRepository).findById(Mockito.any());
    }

    @Test
    public void testarCriacao() throws MyRunTimeException {

        Mockito.when(usuarioRepository.save(Mockito.any()))
                .thenReturn(criacao());
        usuarioService.create(criacaoDto());
        Mockito.verify(usuarioRepository).save(Mockito.any());

    }
    @Test
    public void testarCriacaoGestor() throws MyRunTimeException {

        Mockito.when(usuarioRepository.save(Mockito.any()))
                .thenReturn(criacaoGestor());
        usuarioService.create(criacaoDtoGestor());
        Mockito.verify(usuarioRepository).save(Mockito.any());

    }

    @Test
    public void testarAlteracao() throws Exception {

        Mockito.when(usuarioRepository.save(Mockito.any()))
                .thenReturn(criacao());
        usuarioService.update(criacaoDto());
        Mockito.verify(usuarioRepository).save(Mockito.any());

    }
    private Usuario criacao(){
        return  new Usuario().builder()
                .id(1)
                .email("teste@teste.com")
                .name("teste")
                .password("teste")
                .typeUser(TipoUsuario.CLIENTE)
                .build();
    }

    private Usuario criacaoGestor(){
        return  new Usuario().builder()
                .id(1)
                .email("teste@teste.com")
                .name("teste")
                .password("teste")
                .typeUser(TipoUsuario.GESTOR)
                .build();
    }

    private UsuarioDto criacaoDto(){
        return  new UsuarioDto().builder()
                .id(1)
                .email("teste@teste.com")
                .name("teste")
                .password("teste")
                .typeUser(TipoUsuarioDto.CLIENTE)
                .build();
    }

    private UsuarioDto criacaoDtoGestor(){
        return  new UsuarioDto().builder()
                .id(1)
                .email("teste@teste.com")
                .name("teste")
                .password("teste")
                .typeUser(TipoUsuarioDto.CLIENTE)
                .build();
    }

    private LoginDto loginDto(){
        return new LoginDto("teste@teste.com","teste");
    }
}
