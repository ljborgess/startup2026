package com.startUP.forumup.api.domain.repository;

import com.startUP.forumup.api.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
}
