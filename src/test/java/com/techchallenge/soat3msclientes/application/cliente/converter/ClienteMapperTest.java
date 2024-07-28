package com.techchallenge.soat3msclientes.application.cliente.converter;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClienteMapperTest {

    private ClienteMapper clienteMapper;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        clienteMapper = new ClienteMapper(modelMapper);
    }

    @Test
    void testClienteInputToCliente() {

        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteRequest clienteRequest = ClienteRequest.builder().id(uuid).nome(nome).cpf(cpf).email(email).telefone(telefone).build();

        ClienteModel clienteModel = clienteMapper.clienteInputToCliente(clienteRequest);

        assertEquals(uuid, clienteModel.getId());
        assertEquals(nome, clienteModel.getNome());
        assertEquals(cpf, clienteModel.getCpf());
        assertEquals(email, clienteModel.getEmail());
        assertEquals(telefone, clienteModel.getTelefone());
        assertEquals(false, clienteModel.isSituacao());
    }

    @Test
    void testClienteToClienteModel() {

        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteModel clienteModel = ClienteModel.builder().id(uuid).nome(nome).cpf(cpf).email(email).telefone(telefone).build();

        ClienteResponse clienteResponse = clienteMapper.clienteToClienteModel(clienteModel);

        assertEquals(uuid, clienteResponse.getId());
        assertEquals(nome, clienteResponse.getNome());
        assertEquals(cpf, clienteResponse.getCpf());
        assertEquals(email, clienteResponse.getEmail());
        assertEquals(telefone, clienteResponse.getTelefone());
    }

    @Test
    void testClienteToClienteResponse() {
        UUID uuid = UUID.randomUUID();
        String nome = "João";
        String cpf = "12345678901";
        String email = "joao@example.com";
        String telefone = "123456789";

        ClienteModel clienteModel = ClienteModel.builder().id(uuid).nome(nome).cpf(cpf).email(email).telefone(telefone).build();

        ClienteResponse clienteResponse = clienteMapper.clienteToClienteResponse(clienteModel);

        assertEquals(uuid, clienteResponse.getId());
        assertEquals(nome, clienteResponse.getNome());
        assertEquals(cpf, clienteResponse.getCpf());
        assertEquals(email, clienteResponse.getEmail());
        assertEquals(telefone, clienteResponse.getTelefone());
    }

    @Test
    void testGetClientes() {

        List<ClienteModel> clienteModels = new ArrayList<>();
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        String nome1 = "João";
        String nome2 = "Maria";
        String cpf1 = "12345678901";
        String cpf2 = "98765432101";
        String email1 = "joao@example.com";
        String email2 = "maria@example.com";
        String telefone1 = "123456789";
        String telefone2 = "987654321";

        clienteModels.add(ClienteModel.builder().id(uuid1).nome(nome1).cpf(cpf1).email(email1).telefone(telefone1).build());
        clienteModels.add(ClienteModel.builder().id(uuid2).nome(nome2).cpf(cpf2).email(email2).telefone(telefone2).build());

        List<ClienteResponse> clienteResponses = clienteMapper.getClientes(clienteModels);

        assertEquals(2, clienteResponses.size());

        ClienteResponse clienteResponse1 = clienteResponses.get(0);
        assertEquals(uuid1, clienteResponse1.getId());
        assertEquals(nome1, clienteResponse1.getNome());
        assertEquals(cpf1, clienteResponse1.getCpf());
        assertEquals(email1, clienteResponse1.getEmail());
        assertEquals(telefone1, clienteResponse1.getTelefone());

        ClienteResponse clienteResponse2 = clienteResponses.get(1);
        assertEquals(uuid2, clienteResponse2.getId());
        assertEquals(nome2, clienteResponse2.getNome());
        assertEquals(cpf2, clienteResponse2.getCpf());
        assertEquals(email2, clienteResponse2.getEmail());
        assertEquals(telefone2, clienteResponse2.getTelefone());
    }

    @Test
    void testClientesToClientesModel() {
        Collection<ClienteModel> clienteModels = new ArrayList<>();
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        String nome1 = "João";
        String nome2 = "Maria";
        String cpf1 = "12345678901";
        String cpf2 = "98765432101";
        String email1 = "joao@example.com";
        String email2 = "maria@example.com";
        String telefone1 = "123456789";
        String telefone2 = "987654321";

        clienteModels.add(ClienteModel.builder().id(uuid1).nome(nome1).cpf(cpf1).email(email1).telefone(telefone1).build());
        clienteModels.add(ClienteModel.builder().id(uuid2).nome(nome2).cpf(cpf2).email(email2).telefone(telefone2).build());

        Collection<ClienteResponse> clienteResponses = clienteMapper.clientesToClientesModel(clienteModels);

        assertEquals(2, clienteResponses.size());

        List<UUID> uuids = clienteResponses.stream().map(ClienteResponse::getId).collect(Collectors.toList());
        List<String> nomes = clienteResponses.stream().map(ClienteResponse::getNome).collect(Collectors.toList());
        List<String> cpfs = clienteResponses.stream().map(ClienteResponse::getCpf).collect(Collectors.toList());
        List<String> emails = clienteResponses.stream().map(ClienteResponse::getEmail).collect(Collectors.toList());
        List<String> telefones = clienteResponses.stream().map(ClienteResponse::getTelefone).collect(Collectors.toList());

        assertEquals(uuid1, uuids.get(0));
        assertEquals(uuid2, uuids.get(1));

        assertEquals(nome1, nomes.get(0));
        assertEquals(nome2, nomes.get(1));

        assertEquals(cpf1, cpfs.get(0));
        assertEquals(cpf2, cpfs.get(1));

        assertEquals(email1, emails.get(0));
        assertEquals(email2, emails.get(1));

        assertEquals(telefone1, telefones.get(0));
        assertEquals(telefone2, telefones.get(1));
    }


    @Test
    void testCopyToDomainObject() {
        ClienteRequest clienteRequest = ClienteRequest.builder().id(UUID.randomUUID()).nome("João").cpf("12345678901").email("joao@example.com").telefone("123456789").build();

        ClienteModel clienteModel = ClienteModel.builder().build();

        clienteMapper.copyToDomainObject(clienteRequest, clienteModel);

        assertEquals(clienteRequest.getNome(), clienteModel.getNome());
        assertEquals(clienteRequest.getCpf(), clienteModel.getCpf());
        assertEquals(clienteRequest.getEmail(), clienteModel.getEmail());
        assertEquals(clienteRequest.getTelefone(), clienteModel.getTelefone());
    }

    @Test
    void testClienteToClienteResponse_NullClienteModel() {
        assertThrows(NullPointerException.class, () -> clienteMapper.clienteToClienteResponse(null));
    }

    @Test
    void testGetClientes_EmptyList() {
        List<ClienteModel> emptyList = Collections.emptyList();
        List<ClienteResponse> result = clienteMapper.getClientes(emptyList);
        assertEquals(0, result.size());
    }

    @Test
    void testClientesToClientesModel_EmptyCollection() {
        Collection<ClienteModel> emptyCollection = Collections.emptyList();
        Collection<ClienteResponse> result = clienteMapper.clientesToClientesModel(emptyCollection);
        assertEquals(0, result.size());
    }

    @Test
    void testClienteToClienteModel_InvalidMapping() {
        ClienteModel clienteModel = mock(ClienteModel.class);
        when(clienteModel.getId()).thenThrow(RuntimeException.class); // Simulate an invalid mapping
        assertThrows(RuntimeException.class, () -> clienteMapper.clienteToClienteModel(clienteModel));
    }


}