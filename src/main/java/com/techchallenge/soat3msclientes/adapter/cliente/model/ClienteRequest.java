package com.techchallenge.soat3msclientes.adapter.cliente.model;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private UUID uuid;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
