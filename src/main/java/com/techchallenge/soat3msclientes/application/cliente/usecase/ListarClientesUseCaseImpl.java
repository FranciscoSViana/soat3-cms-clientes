package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ListarClientesUseCaseImpl implements ListarClientesUseCase {

    private final ClienteService clienteService;
    @Override
    public ClienteContentResponse buscarTodos() {
        return clienteService.buscarTodos();
    }
}
