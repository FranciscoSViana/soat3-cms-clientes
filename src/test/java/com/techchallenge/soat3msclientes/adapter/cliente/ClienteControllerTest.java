package com.techchallenge.soat3msclientes.adapter.cliente;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.usecase.ClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {

    @Mock
    private ClienteUseCase clienteUseCase;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTodosClientes() {
        ClienteContentResponse clienteContentResponse = new ClienteContentResponse();
        when(clienteUseCase.buscarTodos()).thenReturn(clienteContentResponse);

        ResponseEntity<ClienteContentResponse> responseEntity = clienteController.todosClientes();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clienteContentResponse, responseEntity.getBody());
    }

    @Test
    void testBuscarPorCpf() {
        ClienteResponse clienteResponse = new ClienteResponse();
        String cpf = "12345678901";
        when(clienteUseCase.buscarPorCpf(cpf)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.buscarPorCpf(cpf);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clienteResponse, responseEntity.getBody());
    }

    @Test
    void testSalvarCliente() {
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();
        when(clienteUseCase.salvar(clienteRequest)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.salvarCliente(clienteRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clienteResponse, responseEntity.getBody());
    }

    @Test
    void testAtualizar() {
        UUID clienteId = UUID.randomUUID();
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();
        when(clienteUseCase.atualizar(clienteId, clienteRequest)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.atualizar(clienteId, clienteRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clienteResponse, responseEntity.getBody());
    }

    @Test
    void testExcluirCliente() {
        UUID clienteId = UUID.randomUUID();

        clienteController.excluirCliente(clienteId);

        verify(clienteUseCase, times(1)).excluirCliente(clienteId);
    }
}
