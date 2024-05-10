package com.techchallenge.soat3msclientes.application.cliente.factory;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.application.cliente.exception.NegocioException;
import com.techchallenge.soat3msclientes.commons.utils.DataProvider;
import com.techchallenge.soat3msclientes.domain.constant.I18n;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteFactoryTest {

    private ClienteFactory clienteFactory;
    private DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = mock(DataProvider.class);
        clienteFactory = new ClienteFactory(dataProvider);
    }

    @Test
    void testNovo_ClienteRequestNull() {

        ClienteRequest clienteRequest = null;

        NegocioException exception = assertThrows(NegocioException.class, () -> clienteFactory.novo(clienteRequest));
        assertEquals(I18n.CLIENTE_NAO_PODE_SER_NULO, exception.getMessage());
    }

    @Test
    void testNovo() {

        LocalDateTime dataAtual = LocalDateTime.now();
        ClienteRequest clienteRequest = ClienteRequest.builder()
                .nome("João")
                .cpf("12345678901")
                .email("joao@example.com")
                .telefone("123456789")
                .build();
        when(dataProvider.obterDataHoraAtual()).thenReturn(dataAtual);

        ClienteModel clienteModel = clienteFactory.novo(clienteRequest);

        assertNotNull(clienteModel.getId());
        assertEquals(dataAtual, clienteModel.getDataHoraCriacao());
        assertTrue(clienteModel.isSituacao());
        assertEquals(clienteRequest.getNome(), clienteModel.getNome());
        assertEquals(clienteRequest.getCpf(), clienteModel.getCpf());
        assertEquals(clienteRequest.getEmail(), clienteModel.getEmail());
        assertEquals(clienteRequest.getTelefone(), clienteModel.getTelefone());

        verify(dataProvider, times(1)).obterDataHoraAtual();
    }
}