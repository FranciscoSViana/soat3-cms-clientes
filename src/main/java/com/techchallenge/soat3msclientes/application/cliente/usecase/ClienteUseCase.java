package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;

import java.util.UUID;

public interface ClienteUseCase {
    ClienteResponse atualizar(UUID clienteId, ClienteRequest clienteRequest);
    ClienteResponse buscarPorCpf(String cpf);
    void excluirCliente(UUID clienteId);
    ClienteContentResponse buscarTodos();
    ClienteResponse salvar(ClienteRequest clienteRequest);
    ClienteModel buscarPorId(UUID id);
    ClienteResponse inativacao(UUID id);
}
