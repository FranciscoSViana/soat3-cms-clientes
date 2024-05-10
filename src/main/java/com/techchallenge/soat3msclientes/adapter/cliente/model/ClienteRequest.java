package com.techchallenge.soat3msclientes.adapter.cliente.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClienteRequest {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
