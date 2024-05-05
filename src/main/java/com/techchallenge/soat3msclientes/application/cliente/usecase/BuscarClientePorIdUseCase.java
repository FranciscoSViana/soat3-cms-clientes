package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.domain.model.ClienteModel;

import java.util.UUID;

public interface BuscarClientePorIdUseCase {
    ClienteModel buscarPorId(UUID id);

}
