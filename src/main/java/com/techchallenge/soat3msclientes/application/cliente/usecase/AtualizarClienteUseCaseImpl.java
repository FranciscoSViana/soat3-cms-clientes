package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AtualizarClienteUseCaseImpl implements AtualizarClienteUseCase {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse atualizar(UUID clienteId, ClienteRequest clienteRequest) {
        return clienteService.atualizar(clienteId, clienteRequest);
    }

}
