package com.techchallenge.soat3msclientes.adapter.cliente;

import com.techchallenge.soat3msclientes.adapter.cliente.model.ClienteContentResponse;
import com.techchallenge.soat3msclientes.application.cliente.usecase.ListarClientesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/clientes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteController {

    private final ListarClientesUseCase listarClientesUseCase;


    @GetMapping
    public ResponseEntity<ClienteContentResponse> todosClientes() {

        ClienteContentResponse clienteContentResponse = listarClientesUseCase.buscarTodos();

        return new ResponseEntity<>(clienteContentResponse, HttpStatus.OK);
    }


}
