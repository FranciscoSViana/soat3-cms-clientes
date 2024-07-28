package com.techchallenge.soat3msclientes.application.cliente.service;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;

import java.util.UUID;

public interface ClienteService {

    ClienteContentResponse buscarTodos();
    ClienteResponse buscarPorCpf(String cpf);

    ClienteResponse salvar(ClienteRequest clienteRequest);

    ClienteResponse atualizar(UUID clienteId, ClienteRequest clienteRequest);

    ClienteModel buscarOuFalhar(UUID clienteId);

    void excluirCliente(UUID clienteId);

    ClienteResponse inativacao(ClienteModel clienteModel);
}
