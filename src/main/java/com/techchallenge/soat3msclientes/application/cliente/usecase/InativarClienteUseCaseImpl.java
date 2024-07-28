package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InativarClienteUseCaseImpl implements InativarClienteUseCase{

    private final ClienteService clienteService;

    @Override
    public ClienteResponse inativar(ClienteModel clienteModel) {
        return clienteService.inativacao(clienteModel);
    }
}
