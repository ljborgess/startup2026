package com.startUP.forumup.api.domain.dto;

import com.startUP.forumup.api.domain.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDTO {

    private Long id;       // Agora retornamos o ID gerado
    private String nome;
    private String email;
    private String regiao;
    // NOTE: Não existe o campo 'senha' aqui. Segurança total!

    // Construtor Especial:
    // Ele pega a Entidade completa (Client) e tira apenas o que queremos mostrar
    public ClientResponseDTO(Client client) {
        this.id = client.getId();
        this.nome = client.getNome();
        this.email = client.getEmail();
        this.regiao = client.getRegiao();
    }
}