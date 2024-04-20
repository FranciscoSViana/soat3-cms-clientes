package com.techchallenge.soat3msclientes.adapter.cliente.model;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
