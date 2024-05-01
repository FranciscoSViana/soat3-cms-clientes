package com.techchallenge.soat3msclientes.bdd;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.converter.ClienteMapper;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteServiceImpl;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import com.techchallenge.soat3msclientes.infrastruture.cliente.repository.ClienteRepository;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

public class DefinicaoPassos {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    private ClienteContentResponse expectedResponse;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Dado("que existem clientes cadastrados no sistema")
    public void queExistemClientesCadastradosNoSistema() {
        List<ClienteModel> listaClientes = new ArrayList<>();
        listaClientes.add(ClienteModel.builder().id(UUID.randomUUID()).nome("Cliente 1").cpf("12345678901").build());
        listaClientes.add(ClienteModel.builder().id(UUID.randomUUID()).nome("Cliente 2").cpf("98765432109").build());

        when(clienteRepository.findAll()).thenReturn(listaClientes);

        List<ClienteResponse> clienteResponses = listaClientes.stream()
                .map(clienteMapper::clienteToClienteResponse)
                .collect(Collectors.toList());
        expectedResponse = ClienteContentResponse.builder().content(clienteResponses).build();
    }

    @Quando("eu busco um cliente pelo CPF {string}")
    public void euBuscoUmClientePeloCPF(String cpf) {
        ClienteModel cliente = ClienteModel.builder().id(UUID.randomUUID()).nome("Cliente Teste").cpf(cpf).build();

        ClienteResponse clienteResponse = ClienteResponse.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf()) // Passando o CPF corretamente
                .build();

        when(clienteRepository.findByCpf(cpf)).thenReturn(cliente);

        when(clienteMapper.clienteToClienteResponse(cliente)).thenReturn(clienteResponse);

        when(clienteService.buscarPorCpf(cpf)).thenReturn(clienteResponse);
    }


    @Então("o cliente com o CPF {string} deve ser retornado com sucesso")
    public void oClienteComOCPFSerRetornadoComSucesso(String cpf) {
        ClienteModel clienteEsperado = clienteRepository.findByCpf(cpf);
        ClienteResponse clienteResponseEsperado = clienteMapper.clienteToClienteResponse(clienteEsperado);
        List<ClienteResponse> clienteResponseList = new ArrayList<>();
        clienteResponseList.add(clienteResponseEsperado);
        ClienteContentResponse expectedResponse = ClienteContentResponse.builder().content(clienteResponseList).build();
        ClienteResponse response = clienteService.buscarPorCpf(cpf);
        Assertions.assertEquals(expectedResponse.getContent().get(0), response);
    }



}
