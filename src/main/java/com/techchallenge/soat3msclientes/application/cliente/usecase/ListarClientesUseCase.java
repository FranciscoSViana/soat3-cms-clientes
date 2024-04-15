package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;

@FunctionalInterface
public interface ListarClientesUseCase {

    ClienteContentResponse buscarTodos();


}
