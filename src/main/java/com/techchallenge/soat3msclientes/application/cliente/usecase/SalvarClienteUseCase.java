package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;

@FunctionalInterface
public interface SalvarClienteUseCase {
    ClienteResponse salvar(ClienteRequest clienteRequest);

}
