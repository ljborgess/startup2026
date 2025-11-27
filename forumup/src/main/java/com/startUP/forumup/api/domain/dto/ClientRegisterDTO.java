package com.startUP.forumup.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRegisterDTO {

    // @NotBlank: O campo não pode ser nulo e nem vazio ""
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    // @Email: O Spring verifica se tem @ e ponto, formato real de email
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O formato do e-mail é inválido")
    private String email;

    // @Size: Garante segurança mínima, impedindo senhas de 1 letra
    private String senha;

    // Estes campos são opcionais, então não coloquei @NotBlank
    private String telefone;
    private String regiao;
}