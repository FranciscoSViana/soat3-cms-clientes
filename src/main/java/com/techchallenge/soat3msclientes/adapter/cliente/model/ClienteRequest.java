package com.techchallenge.soat3msclientes.adapter.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

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
