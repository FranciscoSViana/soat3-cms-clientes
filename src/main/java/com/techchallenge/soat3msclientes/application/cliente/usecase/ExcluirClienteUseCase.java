package com.techchallenge.soat3msclientes.application.cliente.usecase;

import java.util.UUID;

@FunctionalInterface
public interface ExcluirClienteUseCase {
    void excluirCliente(UUID clienteId);


}
