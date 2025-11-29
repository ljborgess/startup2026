package com.startUP.forumup.api.domain.repository;

import com.startUP.forumup.api.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
// Pode remover o import de UserDetails se ele não for usado mais aqui

public interface ClientRepository extends JpaRepository<Client, Long> {

    // Agora retorna 'Client' específico, em vez do genérico 'UserDetails'
    Client findByEmail(String email);

}