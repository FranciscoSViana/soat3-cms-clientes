package com.techchallenge.soat3msclientes.adapter.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/clientes")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClienteController {
}
