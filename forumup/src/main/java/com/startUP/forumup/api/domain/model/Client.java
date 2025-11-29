package com.startUP.forumup.api.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data // O Lombok gera Getters, Setters, etc.
@Entity
@NoArgsConstructor // Obrigatório para o JPA
@AllArgsConstructor
@Table(name = "client") // Boa prática definir o nome da tabela
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String regiao;
    private String telefone;

    @Column(unique = true) // emails não podem repetir
    private String email;

    private String senha;

    // MÉTODOS OBRIGATÓRIOS DO SPRING SECURITY (UserDetails) ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Todo mundo que logar vai ter o perfil de "ROLE_USER"
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha; //  senha está no campo 'senha'
    }

    @Override
    public String getUsername() {
        return email; //  login é o 'email'
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}