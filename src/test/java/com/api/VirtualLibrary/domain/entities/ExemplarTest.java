package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExemplarTest {

    Exemplar exemplar = new Exemplar(TipoDeCirculacao.restrito, new Livro("titulo", BigDecimal.TEN, "123"));

    @ParameterizedTest
    @DisplayName("Deve retornar true se o tipo de circulação for restrito")
    @CsvSource({
            "true, restrito",
            "false, livre"
    })
    void isRestrito(boolean esperado, TipoDeCirculacao tipoDeCirculacao) {
        assertEquals(esperado, exemplar.isRestrito(tipoDeCirculacao));
    }
}