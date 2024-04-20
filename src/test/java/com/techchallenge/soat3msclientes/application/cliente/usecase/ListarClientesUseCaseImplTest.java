package com.techchallenge.soat3msclientes.application.cliente.usecase;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListarClientesUseCaseImplTest {

    @Mock
    private ClienteService clienteService;

    private ListarClientesUseCase listarClientesUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        listarClientesUseCase = new ListarClientesUseCaseImpl(clienteService);
    }

    @Test
    void testBuscarTodos() {
        ClienteContentResponse clienteContentResponse = new ClienteContentResponse();
        when(clienteService.buscarTodos()).thenReturn(clienteContentResponse);

        ClienteContentResponse result = listarClientesUseCase.buscarTodos();

        assertEquals(clienteContentResponse, result);
    }
}