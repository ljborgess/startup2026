package com.startUP.forumup.api.service;

import com.startUP.forumup.api.domain.model.Client;
import com.startUP.forumup.api.domain.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    public Client cadastrar(Client client) {

        // Se já existir email → não deixar cadastrar
        Client existente = repository.findByEmail(client.getEmail());
        if (existente != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        return repository.save(client);
    }

    // LOGIN
    public Client logar(String email, String senha) {
        Client c = repository.findByEmail(email);

        if (c == null) return null;
        if (!c.getSenha().equals(senha)) return null;

        return c;
    }
    public List<Client> listarTodos() {
        return repository.findAll();
    }

    public void remove(long id) {
    }
}
