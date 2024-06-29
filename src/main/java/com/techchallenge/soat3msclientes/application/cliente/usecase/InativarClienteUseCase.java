package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;

@FunctionalInterface
public interface InativarClienteUseCase {

    ClienteResponse inativar(ClienteModel clienteModel);
}