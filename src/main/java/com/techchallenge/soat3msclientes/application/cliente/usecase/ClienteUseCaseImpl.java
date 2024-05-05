package com.techchallenge.soat3msclientes.application.cliente.usecase;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.domain.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteUseCaseImpl implements ClienteUseCase {


    private final AtualizarClienteUseCase atualizarClienteUseCase;

    private final BuscarClientePorCPFUseCase buscarClientePorCPFUseCase;

    private final ExcluirClienteUseCase excluirClienteUseCase;

    private final ListarClientesUseCase listarClientesUseCase;

    private final SalvarClienteUseCase salvarClienteUseCase;

    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;


    @Override
    public ClienteResponse atualizar(UUID clienteId, ClienteRequest clienteRequest) {
        return atualizarClienteUseCase.atualizar(clienteId, clienteRequest);
    }

    @Override
    public ClienteResponse buscarPorCpf(String cpf) {
        return buscarClientePorCPFUseCase.buscarPorCpf(cpf);
    }

    @Override
    public void excluirCliente(UUID clienteId) {
        excluirClienteUseCase.excluirCliente(clienteId);
    }

    @Override
    public ClienteContentResponse buscarTodos() {
        return listarClientesUseCase.buscarTodos();
    }

    @Override
    public ClienteResponse salvar(ClienteRequest clienteRequest) {
        return salvarClienteUseCase.salvar(clienteRequest);
    }

    @Override
    public ClienteModel buscarPorId(UUID id) {
        return buscarClientePorIdUseCase.buscarPorId(id);
    }
}
