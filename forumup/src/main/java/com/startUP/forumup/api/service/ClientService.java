package com.startUP.forumup.api.service;

import com.startUP.forumup.api.domain.model.Client;
import com.startUP.forumup.api.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Importante!
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder; // O codificador que configuramos no SecurityConfig

    // CADASTRAR
    public Client cadastrar(Client client) {

        // 1. Verifica se email já existe (sem precisar de cast feio)
        Client existente = repository.findByEmail(client.getEmail());

        if (existente != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        // 2. CRIPTOGRAFA A SENHA ANTES DE SALVAR
        String senhaCriptografada = passwordEncoder.encode(client.getSenha());
        client.setSenha(senhaCriptografada);

        // 3. Salva no banco
        return repository.save(client);
    }

    public List<Client> listarTodos() {
        return repository.findAll();
    }

    // Corrigindo o método remove que estava vazio
    public void remove(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado para exclusão.");
        }
    }

    // OBS: O método 'logar' foi removido porque agora usamos o AuthController
    // para fazer login via Token JWT.
}