package com.techchallenge.soat3msclientes.application.cliente.usecase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.UUID;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClienteUseCaseImplTest {

    @Mock
    private AtualizarClienteUseCase atualizarClienteUseCase;

    @Mock
    private BuscarClientePorCPFUseCase buscarClientePorCPFUseCase;

    @Mock
    private ExcluirClienteUseCase excluirClienteUseCase;

    @Mock
    private ListarClientesUseCase listarClientesUseCase;

    @Mock
    private SalvarClienteUseCase salvarClienteUseCase;

    @Mock
    private BuscarClientePorIdUseCase buscarClientePorIdUseCase;

    @Mock
    private InativarClienteUseCase inativarClienteUseCase;

    private ClienteUseCase clienteUseCase;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteUseCase = new ClienteUseCaseImpl(
                atualizarClienteUseCase,
                buscarClientePorCPFUseCase,
                excluirClienteUseCase,
                listarClientesUseCase,
                salvarClienteUseCase,
                buscarClientePorIdUseCase,
                inativarClienteUseCase
        );
    }

    @Test
    void testAtualizarCliente() {
        UUID clienteId = UUID.randomUUID();
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();

        when(atualizarClienteUseCase.atualizar(clienteId, clienteRequest)).thenReturn(clienteResponse);

        ClienteResponse response = clienteUseCase.atualizar(clienteId, clienteRequest);

        verify(atualizarClienteUseCase, times(1)).atualizar(clienteId, clienteRequest);

        assertEquals(clienteResponse, response);
    }


    @Test
    void testBuscarPorCpf() {
        String cpf = "12345678900";
        ClienteResponse clienteResponse = new ClienteResponse();

        when(buscarClientePorCPFUseCase.buscarPorCpf(cpf)).thenReturn(clienteResponse);

        ClienteResponse response = clienteUseCase.buscarPorCpf(cpf);

        verify(buscarClientePorCPFUseCase, times(1)).buscarPorCpf(cpf);

        assertEquals(clienteResponse, response);
    }

    @Test
    void testExcluirCliente() {
        UUID clienteId = UUID.randomUUID();

        clienteUseCase.excluirCliente(clienteId);

        verify(excluirClienteUseCase, times(1)).excluirCliente(clienteId);
    }

    @Test
    void testBuscarTodos() {
        ClienteContentResponse clienteContentResponse = new ClienteContentResponse();

        when(listarClientesUseCase.buscarTodos()).thenReturn(clienteContentResponse);

        ClienteContentResponse response = clienteUseCase.buscarTodos();

        verify(listarClientesUseCase, times(1)).buscarTodos();

        assertEquals(clienteContentResponse, response);
    }

    @Test
    void testSalvar() {
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();

        when(salvarClienteUseCase.salvar(clienteRequest)).thenReturn(clienteResponse);

        ClienteResponse response = clienteUseCase.salvar(clienteRequest);

        verify(salvarClienteUseCase, times(1)).salvar(clienteRequest);

        assertEquals(clienteResponse, response);
    }
}