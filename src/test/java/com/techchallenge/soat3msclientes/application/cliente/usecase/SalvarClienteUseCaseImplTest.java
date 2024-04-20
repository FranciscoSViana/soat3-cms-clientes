package com.techchallenge.soat3msclientes.application.cliente.usecase;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalvarClienteUseCaseImplTest {

    @Mock
    private ClienteService clienteService;

    private SalvarClienteUseCase salvarClienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salvarClienteUseCase = new SalvarClienteUseCaseImpl(clienteService);
    }

    @Test
    void testSalvar() {
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();

        when(clienteService.salvar(clienteRequest)).thenReturn(clienteResponse);

        ClienteResponse result = salvarClienteUseCase.salvar(clienteRequest);

        verify(clienteService).salvar(clienteRequest);
        assertEquals(clienteResponse, result);
    }
}