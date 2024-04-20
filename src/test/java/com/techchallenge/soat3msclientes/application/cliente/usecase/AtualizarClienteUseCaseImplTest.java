package com.techchallenge.soat3msclientes.application.cliente.usecase;


import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AtualizarClienteUseCaseImplTest {

    @Mock
    private ClienteService clienteService;

    private AtualizarClienteUseCase atualizarClienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        atualizarClienteUseCase = new AtualizarClienteUseCaseImpl(clienteService);
    }

    @Test
    void testAtualizarCliente() {
        UUID clienteId = UUID.randomUUID();
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponseMock = new ClienteResponse();

        when(clienteService.atualizar(clienteId, clienteRequest)).thenReturn(clienteResponseMock);

        ClienteResponse response = atualizarClienteUseCase.atualizar(clienteId, clienteRequest);

        verify(clienteService).atualizar(clienteId, clienteRequest);

        assertEquals(clienteResponseMock, response);
    }
}