package com.startUP.forumup.api.controller;

import com.startUP.forumup.api.domain.model.Client;
import com.startUP.forumup.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// O que o usuário manda
record DadosLogin(String email, String senha) {}

// O que o usuário recebe
record DadosTokenJWT(String token) {}

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager manager; // O "Gerente" de Segurança

    @Autowired
    private TokenService tokenService; // Onde cria o Token

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosLogin dados) {

        //  Embrulha o email
        var tokenDeAutenticacao = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
    
        //  O Gerente verifica no banco se a senha bate
        // (Se a senha estiver errada, o Spring lança um erro 403 aqui sozinho)
        var authentication = manager.authenticate(tokenDeAutenticacao);

        //  Se passou, pegamos o (Client) que logou
        var clientLogado = (Client) authentication.getPrincipal();

        System.out.println("DEBUG - Login efetuado para: " + clientLogado.getEmail());
        System.out.println("DEBUG - Nome do usuario: " + clientLogado.getNome());

        //  Geramos a (Token JWT) para ele
        var tokenJWT = tokenService.gerarToken(clientLogado);

        //  Devolvemos o token num JSON bonito
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}