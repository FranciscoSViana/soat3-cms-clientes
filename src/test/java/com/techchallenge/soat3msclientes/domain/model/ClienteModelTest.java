package com.techchallenge.soat3msclientes.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClienteModelTest {

    @Mock
    private ClienteModel clienteModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        clienteModel = new ClienteModel();
    }

    @Test
    void testId() {
        UUID id = UUID.randomUUID();
        clienteModel.setId(id);
        assertEquals(id, clienteModel.getId());
    }

    @Test
    void testNome() {
        String nome = "João";
        clienteModel.setNome(nome);
        assertEquals(nome, clienteModel.getNome());
    }

    @Test
    void testCpf() {
        String cpf = "123.456.789-10";
        clienteModel.setCpf(cpf);
        assertEquals(cpf, clienteModel.getCpf());
    }

    @Test
    void testEmail() {
        String email = "joao@example.com";
        clienteModel.setEmail(email);
        assertEquals(email, clienteModel.getEmail());
    }

    @Test
    void testTelefone() {
        String telefone = "(12) 3456-7890";
        clienteModel.setTelefone(telefone);
        assertEquals(telefone, clienteModel.getTelefone());
    }

    @Test
    void testDataHoraCriacao() {
        LocalDateTime dataHoraCriacao = LocalDateTime.now();
        clienteModel.setDataHoraCriacao(dataHoraCriacao);
        assertEquals(dataHoraCriacao, clienteModel.getDataHoraCriacao());
    }

    @Test
    void testDataHoraAlteracao() {
        LocalDateTime dataHoraAlteracao = LocalDateTime.now();
        clienteModel.setDataHoraAlteracao(dataHoraAlteracao);
        assertEquals(dataHoraAlteracao, clienteModel.getDataHoraAlteracao());
    }

    @Test
    void testSituacao() {
        clienteModel.setSituacao(true);
        assertTrue(clienteModel.isSituacao());
    }
}