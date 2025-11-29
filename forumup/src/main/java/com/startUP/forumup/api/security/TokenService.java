package com.startUP.forumup.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.startUP.forumup.api.domain.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    //
    //
    private String secret = "123";

    // 1. GERAR TOKEN
    public String gerarToken(Client client) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API ForumUp")
                    // Usamos o email do Client como "Subject"
                    .withSubject(client.getEmail())
                    .withClaim("id", client.getId())     // Guardamos o ID
                    .withClaim("nome", client.getNome()) // Guardamos o Nome
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    // 2. VALIDAR TOKEN
    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API ForumUp")
                    .build()
                    .verify(tokenJWT) // Verifica assinatura e validade
                    .getSubject();    // Devolve o email que guardamos lá em cima
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        // Token expira em 2 horas (Horário de Brasília -03:00)
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}