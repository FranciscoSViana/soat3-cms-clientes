package com.techchallenge.soat3msclientes.application.cliente.service;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.converter.ClienteMapper;
import com.techchallenge.soat3msclientes.application.cliente.exception.ClienteNaoEncontradoException;
import com.techchallenge.soat3msclientes.application.cliente.exception.NegocioException;
import com.techchallenge.soat3msclientes.application.cliente.factory.ClienteFactory;
import com.techchallenge.soat3msclientes.domain.constant.I18n;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import com.techchallenge.soat3msclientes.infrastruture.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteFactory clienteFactory;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBuscarTodos() {
        List<ClienteModel> clienteModels = new ArrayList<>();
        List<ClienteResponse> clienteResponses = new ArrayList<>();

        when(clienteRepository.findAll()).thenReturn(clienteModels);
        when(clienteMapper.getClientes(clienteModels)).thenReturn(clienteResponses);

        ClienteContentResponse response = clienteService.buscarTodos();

        assertNotNull(response);
        assertEquals(clienteResponses, response.getContent());

        verify(clienteRepository, times(1)).findAll();
        verify(clienteMapper, times(1)).getClientes(clienteModels);
    }

    @Test
    void testBuscarPorCpf_Existente() {
        String cpf = "12345678901";
        ClienteModel clienteModel = mock(ClienteModel.class);
        ClienteResponse clienteResponse = mock(ClienteResponse.class);

        when(clienteRepository.findByCpf(cpf)).thenReturn(clienteModel);
        when(clienteMapper.clienteToClienteModel(clienteModel)).thenReturn(clienteResponse);

        ClienteResponse response = clienteService.buscarPorCpf(cpf);

        assertNotNull(response);
        assertEquals(clienteResponse, response);

        verify(clienteRepository, times(1)).findByCpf(cpf);
        verify(clienteMapper, times(1)).clienteToClienteModel(clienteModel);
    }

    @Test
    void testBuscarPorCpf_NaoExistente() {
        String cpf = "12345678901";

        when(clienteRepository.findByCpf(cpf)).thenReturn(null);

        ClienteNaoEncontradoException exception = assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.buscarPorCpf(cpf));
        assertEquals(I18n.CLIENTE_NAO_ENCONTRADO_PARA_O_CPF + cpf, exception.getMessage());

        verify(clienteRepository, times(1)).findByCpf(cpf);
        verify(clienteMapper, never()).clienteToClienteModel(any());
    }

    @Test
    void testSalvar_Sucesso() {
        ClienteRequest clienteRequest = mock(ClienteRequest.class);
        ClienteModel clienteModel = mock(ClienteModel.class);
        ClienteResponse clienteResponse = mock(ClienteResponse.class);

        when(clienteRequest.getCpf()).thenReturn("12345678901");
        when(clienteRepository.findByCpf("12345678901")).thenReturn(null);
        when(clienteFactory.novo(clienteRequest)).thenReturn(clienteModel);
        when(clienteRepository.save(clienteModel)).thenReturn(clienteModel);
        when(clienteMapper.clienteToClienteResponse(clienteModel)).thenReturn(clienteResponse);

        ClienteResponse response = clienteService.salvar(clienteRequest);

        assertNotNull(response);
        assertEquals(clienteResponse, response);

        verify(clienteRepository, times(1)).findByCpf("12345678901");
        verify(clienteFactory, times(1)).novo(clienteRequest);
        verify(clienteRepository, times(1)).save(clienteModel);
        verify(clienteMapper, times(1)).clienteToClienteResponse(clienteModel);
    }

    @Test
    void testSalvar_Falha_ClienteJaCadastrado() {
        ClienteRequest clienteRequest = mock(ClienteRequest.class);

        when(clienteRequest.getCpf()).thenReturn("12345678901");
        when(clienteRepository.findByCpf("12345678901")).thenReturn(mock(ClienteModel.class));

        NegocioException exception = assertThrows(NegocioException.class, () -> clienteService.salvar(clienteRequest));
        assertEquals(I18n.CLIENTE_JA_CADASTRADO_PARA_O_CPF + "12345678901", exception.getMessage());

        verify(clienteRepository, times(1)).findByCpf("12345678901");
        verify(clienteFactory, never()).novo(any());
        verify(clienteRepository, never()).save(any());
        verify(clienteMapper, never()).clienteToClienteResponse(any());
    }

    @Test
    void testAtualizar_Sucesso() {

        UUID clienteId = UUID.randomUUID();
        ClienteRequest clienteRequest = mock(ClienteRequest.class);
        ClienteModel clienteModel = mock(ClienteModel.class);
        ClienteResponse clienteResponse = mock(ClienteResponse.class);

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(clienteModel));
        when(clienteMapper.clienteToClienteModel(clienteModel)).thenReturn(clienteResponse);
        when(clienteRepository.save(clienteModel)).thenReturn(clienteModel);

        ClienteResponse response = clienteService.atualizar(clienteId, clienteRequest);

        assertNotNull(response);
        assertEquals(clienteResponse, response);

        verify(clienteRepository, times(1)).findById(clienteId);
        verify(clienteMapper, times(1)).copyToDomainObject(clienteRequest, clienteModel);
        verify(clienteRepository, times(1)).save(clienteModel);
        verify(clienteMapper, times(1)).clienteToClienteModel(clienteModel);
    }

    @Test
    void testBuscarOuFalhar_Existente() {
        UUID clienteId = UUID.randomUUID();
        ClienteModel clienteModel = mock(ClienteModel.class);

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(clienteModel));

        ClienteModel response = clienteService.buscarOuFalhar(clienteId);

        assertNotNull(response);
        assertEquals(clienteModel, response);

        verify(clienteRepository, times(1)).findById(clienteId);
    }

    @Test
    void testBuscarOuFalhar_NaoExistente() {
        UUID clienteId = UUID.randomUUID();

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.empty());

        ClienteNaoEncontradoException exception = assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.buscarOuFalhar(clienteId));
        assertEquals(String.valueOf(clienteId), exception.getMessage());

        verify(clienteRepository, times(1)).findById(clienteId);
    }

    @Test
    void testExcluirCliente_Existente() {
        UUID clienteId = UUID.randomUUID();
        ClienteModel clienteModel = mock(ClienteModel.class);

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(clienteModel));

        clienteService.excluirCliente(clienteId);

        verify(clienteRepository, times(1)).findById(clienteId);
        verify(clienteRepository, times(1)).delete(clienteModel);
    }

    @Test
    void testExcluirCliente_NaoExistente() {
        UUID clienteId = UUID.randomUUID();

        when(clienteRepository.findById(clienteId)).thenReturn(Optional.empty());

        ClienteNaoEncontradoException exception = assertThrows(ClienteNaoEncontradoException.class, () -> clienteService.excluirCliente(clienteId));
        assertEquals(I18n.CLIENTE_NAO_ENCONTRADO_COM_O_ID + clienteId, exception.getMessage());

        verify(clienteRepository, times(1)).findById(clienteId);
        verify(clienteRepository, never()).delete(any());
    }
}