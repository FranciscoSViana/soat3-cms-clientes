package com.techchallenge.soat3msclientes.adapter.cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.usecase.ClienteUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteUseCase clienteUseCase;

    @Test
    void deveriaRetornarListaDeClientesQuandoSolicitado() throws Exception {
        ClienteContentResponse response = ClienteContentResponse.builder().content(Collections.emptyList()).build();
        when(clienteUseCase.buscarTodos()).thenReturn(response);

        mockMvc.perform(get("/v1/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isEmpty());
    }

    @Test
    void deveriaRetornarClienteQuandoSolicitadoPorCpf() throws Exception {
        String cpf = "12345678901";
        ClienteResponse response = ClienteResponse.builder().id(UUID.randomUUID()).nome("John Doe").cpf(cpf).build();
        when(clienteUseCase.buscarPorCpf(cpf)).thenReturn(response);

        mockMvc.perform(get("/v1/clientes/{cpf}", cpf))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(response.getId().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.cpf").value(response.getCpf()));
    }

    @Test
    void deveriaSalvarClienteQuandoSolicitado() throws Exception {
        ClienteRequest request = ClienteRequest.builder().nome("John Doe").cpf("12345678901").build();
        ClienteResponse response = ClienteResponse.builder().id(UUID.randomUUID()).nome("John Doe").cpf("12345678901").build();
        when(clienteUseCase.salvar(any(ClienteRequest.class))).thenReturn(response);

        mockMvc.perform(post("/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(response.getId().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.cpf").value(response.getCpf()));
    }

    @Test
    void deveriaAtualizarClienteQuandoSolicitado() throws Exception {
        UUID id = UUID.randomUUID();
        ClienteRequest request = ClienteRequest.builder().nome("John Doe").cpf("12345678901").build();
        ClienteResponse response = ClienteResponse.builder().id(id).nome("John Doe").cpf("12345678901").build();
        when(clienteUseCase.atualizar(any(UUID.class), any(ClienteRequest.class))).thenReturn(response);

        mockMvc.perform(put("/v1/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(response.getId().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.cpf").value(response.getCpf()));
    }

    @Test
    void deveriaExcluirClienteQuandoSolicitado() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(delete("/v1/clientes/{id}", id))
                .andExpect(status().isOk());
    }
}
