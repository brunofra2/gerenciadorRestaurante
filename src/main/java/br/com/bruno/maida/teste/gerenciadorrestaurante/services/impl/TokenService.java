package br.com.bruno.maida.teste.gerenciadorrestaurante.services.impl;

import br.com.bruno.maida.teste.gerenciadorrestaurante.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario){
        return JWT.create()
                .withIssuer("restaurante")
                .withSubject(usuario.getUsername())
                .withClaim("usuario_id",usuario.getId())
                .withExpiresAt(Date.from(
                        LocalDateTime.now()
                                .plusMinutes(10)
                                .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256("secreta"));
    }

    public String getSubject(String token){
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("restaurante")
                .build().verify(token).getSubject();

    }
}
