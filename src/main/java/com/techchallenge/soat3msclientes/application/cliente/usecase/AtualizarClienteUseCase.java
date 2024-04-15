package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;

import java.util.UUID;

@FunctionalInterface
public interface AtualizarClienteUseCase {

    ClienteResponse atualizar(UUID clienteId, ClienteRequest clienteRequest);

}
