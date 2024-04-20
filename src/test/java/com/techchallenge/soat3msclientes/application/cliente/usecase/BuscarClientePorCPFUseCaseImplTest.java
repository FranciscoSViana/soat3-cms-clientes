package com.techchallenge.soat3msclientes.application.cliente.usecase;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BuscarClientePorCPFUseCaseImplTest {

    @Mock
    private ClienteService clienteService;

    private BuscarClientePorCPFUseCase buscarClientePorCPFUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarClientePorCPFUseCase = new BuscarClientePorCPFUseCaseImpl(clienteService);
    }

    @Test
    void testBuscarPorCpf() {
        String cpf = "12345678900";
        ClienteResponse clienteResponseMock = new ClienteResponse();

        when(clienteService.buscarPorCpf(cpf)).thenReturn(clienteResponseMock);

        ClienteResponse response = buscarClientePorCPFUseCase.buscarPorCpf(cpf);

        verify(clienteService).buscarPorCpf(cpf);

        assertEquals(clienteResponseMock, response);
    }
}