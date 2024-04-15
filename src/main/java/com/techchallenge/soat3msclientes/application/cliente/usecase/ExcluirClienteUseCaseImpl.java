package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ExcluirClienteUseCaseImpl implements ExcluirClienteUseCase{

    private final ClienteService clienteService;
    @Override
    public void excluirCliente(UUID clienteId) {
        clienteService.excluirCliente(clienteId);
    }
}
