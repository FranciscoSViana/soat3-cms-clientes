package com.techchallenge.soat3msclientes.adapter.cliente.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClienteResponseTest {

    @Test
    void testBuilder() {
        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteResponse clienteResponse = ClienteResponse.builder()
                .uuid(uuid)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .build();

        assertEquals(uuid, clienteResponse.getUuid());
        assertEquals(nome, clienteResponse.getNome());
        assertEquals(cpf, clienteResponse.getCpf());
        assertEquals(email, clienteResponse.getEmail());
        assertEquals(telefone, clienteResponse.getTelefone());
    }

    @Test
    void testAllArgsConstructor() {
        UUID uuid = UUID.randomUUID();
        String nome = "Maria";
        String cpf = "98765432101";
        String email = "maria@example.com";
        String telefone = "987654321";

        ClienteResponse clienteResponse = new ClienteResponse(uuid, nome, cpf, email, telefone);

        assertEquals(uuid, clienteResponse.getUuid());
        assertEquals(nome, clienteResponse.getNome());
        assertEquals(cpf, clienteResponse.getCpf());
        assertEquals(email, clienteResponse.getEmail());
        assertEquals(telefone, clienteResponse.getTelefone());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String nome = "Carlos";
        String cpf = "13579246801";
        String email = "carlos@example.com";
        String telefone = "123987456";

        ClienteResponse clienteResponse = ClienteResponse.builder()
                .uuid(uuid)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .build();

        assertNotNull(clienteResponse.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID uuid1 = UUID.randomUUID();
        String nome1 = "Carlos";
        String cpf1 = "12345678901";
        String email1 = "carlos@example.com";
        String telefone1 = "123456789";

        UUID uuid2 = UUID.randomUUID();
        String nome2 = "Lucas";
        String cpf2 = "98765432101";
        String email2 = "lucas@example.com";
        String telefone2 = "987654321";

        ClienteResponse clienteResponse1 = ClienteResponse.builder()
                .uuid(uuid1)
                .nome(nome1)
                .cpf(cpf1)
                .email(email1)
                .telefone(telefone1)
                .build();

        ClienteResponse clienteResponse2 = ClienteResponse.builder()
                .uuid(uuid1)
                .nome(nome1)
                .cpf(cpf1)
                .email(email1)
                .telefone(telefone1)
                .build();

        ClienteResponse clienteResponse3 = ClienteResponse.builder()
                .uuid(uuid2)
                .nome(nome2)
                .cpf(cpf2)
                .email(email2)
                .telefone(telefone2)
                .build();

        ClienteResponse clienteResponse4 = ClienteResponse.builder().build();

        assertEquals(clienteResponse1, clienteResponse1);

        assertEquals(clienteResponse1, clienteResponse2);

        assertNotEquals(clienteResponse1, clienteResponse3);
        assertNotEquals(clienteResponse2, clienteResponse3);

        assertNotEquals(clienteResponse1, null);

        assertNotEquals(clienteResponse1, new Object());

        assertEquals(clienteResponse1.hashCode(), clienteResponse2.hashCode());

        assertNotEquals(clienteResponse1.hashCode(), clienteResponse3.hashCode());

        assertEquals(1244954382, clienteResponse4.hashCode());
    }

    @Test
    void testGetterAndSetter() {
        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setUuid(uuid);
        clienteResponse.setNome(nome);
        clienteResponse.setCpf(cpf);
        clienteResponse.setEmail(email);
        clienteResponse.setTelefone(telefone);

        assertEquals(uuid, clienteResponse.getUuid());
        assertEquals(nome, clienteResponse.getNome());
        assertEquals(cpf, clienteResponse.getCpf());
        assertEquals(email, clienteResponse.getEmail());
        assertEquals(telefone, clienteResponse.getTelefone());
    }
}
