package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.application.cliente.service.ClienteService;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BuscarClientePorIdUseCaseImpl implements BuscarClientePorIdUseCase {

    private final ClienteService clienteService;

    @Override
    public ClienteModel buscarPorId(UUID id) {
        return clienteService.buscarOuFalhar(id);
    }
}
