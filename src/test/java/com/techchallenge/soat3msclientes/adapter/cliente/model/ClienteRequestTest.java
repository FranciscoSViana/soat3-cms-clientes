package com.techchallenge.soat3msclientes.adapter.cliente.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClienteRequestTest {

    @Test
    void testBuilder() {
        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteRequest clienteRequest = ClienteRequest.builder()
                .id(uuid)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .build();

        assertEquals(uuid, clienteRequest.getId());
        assertEquals(nome, clienteRequest.getNome());
        assertEquals(cpf, clienteRequest.getCpf());
        assertEquals(email, clienteRequest.getEmail());
        assertEquals(telefone, clienteRequest.getTelefone());
    }

    @Test
    void testAllArgsConstructor() {
        UUID uuid = UUID.randomUUID();
        String nome = "Maria";
        String cpf = "98765432101";
        String email = "maria@example.com";
        String telefone = "987654321";

        ClienteRequest clienteRequest = new ClienteRequest(uuid, nome, cpf, email, telefone);

        assertEquals(uuid, clienteRequest.getId());
        assertEquals(nome, clienteRequest.getNome());
        assertEquals(cpf, clienteRequest.getCpf());
        assertEquals(email, clienteRequest.getEmail());
        assertEquals(telefone, clienteRequest.getTelefone());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String nome = "Carlos";
        String cpf = "13579246801";
        String email = "carlos@example.com";
        String telefone = "123987456";

        ClienteRequest clienteRequest = ClienteRequest.builder()
                .id(uuid)
                .nome(nome)
                .cpf(cpf)
                .email(email)
                .telefone(telefone)
                .build();

        assertNotNull(clienteRequest.toString());
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

        ClienteRequest clienteRequest1 = ClienteRequest.builder()
                .id(uuid1)
                .nome(nome1)
                .cpf(cpf1)
                .email(email1)
                .telefone(telefone1)
                .build();

        ClienteRequest clienteRequest2 = ClienteRequest.builder()
                .id(uuid1)
                .nome(nome1)
                .cpf(cpf1)
                .email(email1)
                .telefone(telefone1)
                .build();

        ClienteRequest clienteRequest3 = ClienteRequest.builder()
                .id(uuid2)
                .nome(nome2)
                .cpf(cpf2)
                .email(email2)
                .telefone(telefone2)
                .build();

        ClienteRequest clienteRequest4 = ClienteRequest.builder().build();

        assertEquals(clienteRequest1, clienteRequest1);
        assertEquals(clienteRequest1, clienteRequest2);
        assertNotEquals(clienteRequest1, clienteRequest3);
        assertNotEquals(clienteRequest2, clienteRequest3);
        assertNotEquals(null, clienteRequest1);
        assertNotEquals(clienteRequest1, new Object());
        assertEquals(clienteRequest1.hashCode(), clienteRequest2.hashCode());
        assertNotEquals(clienteRequest1.hashCode(), clienteRequest3.hashCode());
        assertEquals(961, clienteRequest4.hashCode());
    }

    @Test
    void testSetterAndGetters() {
        UUID uuid = UUID.randomUUID();
        String nome = "John";
        String cpf = "12345678900";
        String email = "john@example.com";
        String telefone = "123456780";

        ClienteRequest clienteRequest = new ClienteRequest();

        clienteRequest.setId(uuid);
        clienteRequest.setNome(nome);
        clienteRequest.setCpf(cpf);
        clienteRequest.setEmail(email);
        clienteRequest.setTelefone(telefone);

        assertEquals(uuid, clienteRequest.getId());
        assertEquals(nome, clienteRequest.getNome());
        assertEquals(cpf, clienteRequest.getCpf());
        assertEquals(email, clienteRequest.getEmail());
        assertEquals(telefone, clienteRequest.getTelefone());
    }
}
