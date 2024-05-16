package com.techchallenge.soat3msclientes.adapter.cliente.model;

import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteResponse that = (ClienteResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
