package com.techchallenge.soat3msclientes.application.cliente.usecase;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.verify;

class ExcluirClienteUseCaseImplTest {

    @Mock
    private ClienteService clienteService;

    private ExcluirClienteUseCase excluirClienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        excluirClienteUseCase = new ExcluirClienteUseCaseImpl(clienteService);
    }

    @Test
    void testExcluirCliente() {
        UUID clienteId = UUID.randomUUID();

        excluirClienteUseCase.excluirCliente(clienteId);

        verify(clienteService).excluirCliente(clienteId);
    }
}