package com.api.VirtualLibrary.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LivroTest {

    @Test
    @DisplayName("Deveria criar um livro")
    void test1() {
        Livro livro = new Livro("titulo", BigDecimal.TEN, "isbn");
        assertNotNull(livro);
    }
}