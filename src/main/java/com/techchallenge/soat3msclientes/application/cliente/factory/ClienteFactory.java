package com.techchallenge.soat3msclientes.application.cliente.factory;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.application.cliente.exception.NegocioException;
import com.techchallenge.soat3msclientes.commons.utils.DataProvider;
import com.techchallenge.soat3msclientes.domain.constant.I18n;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteFactory {

    private final DataProvider dataProvider;

    public ClienteModel novo(ClienteRequest clienteRequest) {

        if (isNull(clienteRequest)) {
            throw new NegocioException(I18n.CLIENTE_NAO_PODE_SER_NULO);
        }

        return ClienteModel.builder()
                .id(UUID.randomUUID())
                .dataHoraCriacao(dataProvider.obterDataHoraAtual())
                .situacao(Boolean.TRUE)
                .nome(clienteRequest.getNome())
                .cpf(clienteRequest.getCpf())
                .email(clienteRequest.getEmail())
                .telefone(clienteRequest.getTelefone())
                .build();
    }


}
