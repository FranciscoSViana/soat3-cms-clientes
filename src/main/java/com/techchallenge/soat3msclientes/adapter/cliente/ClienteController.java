package com.techchallenge.soat3msclientes.adapter.cliente;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteRequest;
import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteResponse;
import com.techchallenge.soat3msclientes.application.cliente.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/clientes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteController {

    private final ListarClientesUseCase listarClientesUseCase;

    private final BuscarClientePorCPFUseCase buscarClientePorCPFUseCase;

    private final SalvarClienteUseCase salvarClienteUseCase;

    private final AtualizarClienteUseCase atualizarClienteUseCase;

    private final ExcluirClienteUseCase excluirClienteUseCase;

    @GetMapping
    public ResponseEntity<ClienteContentResponse> todosClientes() {

        ClienteContentResponse clienteContentResponse = listarClientesUseCase.buscarTodos();

        return new ResponseEntity<>(clienteContentResponse, HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@PathVariable("cpf") String cpf) {

        ClienteResponse response = buscarClientePorCPFUseCase.buscarPorCpf(cpf);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> salvarCliente(@RequestBody @Valid ClienteRequest clienteRequest) {

        ClienteResponse clienteSalvo = salvarClienteUseCase.salvar(clienteRequest);

        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable UUID clienteId, @RequestBody ClienteRequest clienteRequest) {

        ClienteResponse response = atualizarClienteUseCase.atualizar(clienteId, clienteRequest);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clienteId}")
    public void excluirCliente(@PathVariable UUID clienteId) {
        excluirClienteUseCase.excluirCliente(clienteId);
    }


}
