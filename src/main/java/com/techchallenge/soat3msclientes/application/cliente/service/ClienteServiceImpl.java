package com.techchallenge.soat3msclientes.application.cliente.service;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.converter.ClienteMapper;
import com.techchallenge.soat3msclientes.application.cliente.factory.ClienteFactory;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import com.techchallenge.soat3msclientes.infrastruture.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final ClienteFactory clienteFactory;
    @Override
    public ClienteContentResponse buscarTodos() {

        List<ClienteModel> list = clienteRepository.findAll();

        List<ClienteResponse> clientes = clienteMapper.getClientes(list);

        return ClienteContentResponse.builder().content(clientes).build();
    }
}
