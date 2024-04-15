package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SalvarClienteUseCaseImpl implements SalvarClienteUseCase {

    private final ClienteService clienteService;
    @Override
    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        return clienteService.salvar(clienteRequest);
    }
}
