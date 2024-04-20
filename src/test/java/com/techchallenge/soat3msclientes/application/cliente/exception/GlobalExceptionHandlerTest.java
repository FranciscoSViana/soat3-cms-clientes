package com.techchallenge.soat3msclientes.application.cliente.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    @Test
    void testHandleClienteNaoEncontradoException() {
        ClienteNaoEncontradoException ex = new ClienteNaoEncontradoException("Cliente não encontrado");

        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<String> responseEntity = handler.handleClienteNaoEncontradoException(ex);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Cliente não encontrado", responseEntity.getBody());
    }

    @Test
    void testHandleClienteNegocioException() {
        NegocioException ex = new NegocioException("Erro de negócio");

        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResponseEntity<String> responseEntity = handler.handleClienteNegocioException(ex);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals("Erro de negócio", responseEntity.getBody());
    }
}
