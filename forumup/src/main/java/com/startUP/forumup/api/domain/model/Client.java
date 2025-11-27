package com.startUP.forumup.api.domain.model;

import   jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String regiao;
    private String telefone;
    private String email;
    private String senha;


}
