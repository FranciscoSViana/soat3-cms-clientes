package com.techchallenge.soat3msclientes.commons.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataProviderImplTest {

    @Test
    void testObterDataAtual() {
        DataProviderImpl dataProvider = new DataProviderImpl();

        LocalDate dataAtual = dataProvider.obterDataAtutal();

        assertNotNull(dataAtual);
        assertEquals(LocalDate.now(), dataAtual);
    }

    @Test
    void testObterDataHoraAtual() {
        DataProviderImpl dataProvider = new DataProviderImpl();

        LocalDateTime dataHoraAtual = dataProvider.obterDataHoraAtual();

        assertNotNull(dataHoraAtual);
        assertEquals(LocalDateTime.now().getYear(), dataHoraAtual.getYear());
        assertEquals(LocalDateTime.now().getMonth(), dataHoraAtual.getMonth());
        assertEquals(LocalDateTime.now().getDayOfMonth(), dataHoraAtual.getDayOfMonth());
        assertEquals(LocalDateTime.now().getHour(), dataHoraAtual.getHour());
        assertEquals(LocalDateTime.now().getMinute(), dataHoraAtual.getMinute());
        assertEquals(LocalDateTime.now().getSecond(), dataHoraAtual.getSecond());
    }
}
