package com.techchallenge.soat3msclientes.adapter.cliente.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClienteContentResponseTest {

    @Test
    void testGetterAndSetter() {
        List<ClienteResponse> clientes = mockClientes();

        ClienteContentResponse clienteContentResponse = new ClienteContentResponse(mockClientes());

        assertEquals(clientes, clienteContentResponse.getContent());
    }

    @Test
    void testBuilder() {
        List<ClienteResponse> clientes = mockClientes();

        ClienteContentResponse clienteContentResponse = ClienteContentResponse.builder()
                .content(clientes)
                .build();

        assertEquals(clientes, clienteContentResponse.getContent());
    }

    @Test
    void testAllArgsConstructor() {
        List<ClienteResponse> clientes = mockClientes();

        ClienteContentResponse clienteContentResponse = new ClienteContentResponse(clientes);

        assertEquals(clientes, clienteContentResponse.getContent());
    }

    @Test
    void testConstructorWithNoArgs() {
        ClienteContentResponse clienteContentResponse = new ClienteContentResponse();

        assertNotNull(clienteContentResponse);
    }

    @Test
    void testToString() {
        List<ClienteResponse> clientes = mockClientes();

        ClienteContentResponse clienteContentResponse = new ClienteContentResponse(clientes);

        assertNotNull(clienteContentResponse.toString());
    }

    @Test
    void testGetterAndSetterForContent() {
        ClienteContentResponse clienteContentResponse = new ClienteContentResponse();
        List<ClienteResponse> clientes = mockClientes();

        clienteContentResponse.setContent(clientes);

        assertEquals(clientes, clienteContentResponse.getContent());
    }

    private List<ClienteResponse> mockClientes() {
        UUID uuidCliente1 = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        UUID uuidCliente2 = UUID.fromString("550e8400-e29b-41d4-a716-446655440044");

        ClienteResponse cliente1 = ClienteResponse.builder()
                .id(uuidCliente1)
                .nome("João")
                .email("jp@teste.br")
                .telefone("32138586")
                .cpf("12312312387")
                .build();

        ClienteResponse cliente2 = ClienteResponse.builder()
                .id(uuidCliente2)
                .nome("Maria")
                .email("mr@teste.br")
                .telefone("654658158")
                .cpf("32132132108")
                .build();

        return List.of(cliente1, cliente2);
    }
}
