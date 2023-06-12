package br.com.bruno.maida.teste.gerenciadorrestaurante.services;

import br.com.bruno.maida.teste.gerenciadorrestaurante.GerenciadorRestauranteApplication;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.model.enuns.TipoUsuario;
import br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl.TokenService;
import br.com.bruno.maida.teste.gerenciadorrestaurante.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GerenciadorRestauranteApplication.class)
public class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Test
    public void testToken() {

        // Le usuário
        String user = Utils.captUsuarioLogado();
        assertNotNull(user);
        System.out.println("User lido:");
        System.out.println(user);

        // Gera token
        String jwtToken = tokenService.gerarToken(new Usuario().builder()
                        .id(1)
                        .name("adriele")
                        .email("adriele@gmail.com")
                        .password("$2a$10$OLCwEtseLdSDhzoVNT6hnObhFkaa9JpKBzbBs6Ki4AwZD2K1DGJPe")
                        .typeUser(TipoUsuario.CLIENTE)
                .build());
        System.out.println("jwtToken gerado:");
        System.out.println(jwtToken);
        assertNotNull(jwtToken);

//        // Valida Token
//        boolean ok = tokenService.isTokenValid(jwtToken);
//        assertTrue(ok);
//
//        // Valida login
//        String login = JwtUtil.getLogin(jwtToken);
//        assertEquals("admin",login);
//
//        // Valida roles
//        List<GrantedAuthority> roles = JwtUtil.getRoles(jwtToken);
//        assertNotNull(roles);
//        System.out.println("roles:");
//        System.out.println(roles);
//        String role = roles.get(0).getAuthority();
//        assertEquals(role,"ROLE_ADMIN");
    }

}