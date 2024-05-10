package com.techchallenge.soat3msclientes.domain.constant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class I18nTest {

    @Test
    void testConstantValues() {
        assertEquals("Cliente Invalido", I18n.CLIENTE_INVALIDO);
        assertEquals("Cliente não pode ser nulo.", I18n.CLIENTE_NAO_PODE_SER_NULO);
        assertEquals("Cliente não encontrado com o ID: ", I18n.CLIENTE_NAO_ENCONTRADO_COM_O_ID);
        assertEquals("Cliente não encontrado para o CPF: ", I18n.CLIENTE_NAO_ENCONTRADO_PARA_O_CPF);
        assertEquals("Cliente já cadastrado para o CPF ", I18n.CLIENTE_JA_CADASTRADO_PARA_O_CPF);
    }
}