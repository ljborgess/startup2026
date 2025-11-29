package com.startUP.forumup.api.controller;

import com.startUP.forumup.api.domain.model.Client;
import com.startUP.forumup.api.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // LISTAR TODOS
    @Operation(summary = "Listar todos", description = "Retorna uma lista completa de todos os clientes cadastrados")
    @GetMapping("/all")
    public List<Client> listarTodos() {
        return service.listarTodos();
    }

    // CADASTRO
    @Operation(summary = "Cadastrar novo cliente", description = "Recebe um JSON com os dados do cliente e salva no banco")
    @PostMapping("/register")
    public Client register(@RequestBody Client client) {
        return service.cadastrar(client);
    }


    // Agora o login é feito exclusivamente pelo AuthController

    // DELETE
    @Operation(summary = "Deletar client", description = "Remove o cliente do banco de dados")
    @DeleteMapping("/delete/{id}") // Melhor usar DeleteMapping para deletar
    public void delete(@PathVariable long id) {
        service.remove(id);
    }
}