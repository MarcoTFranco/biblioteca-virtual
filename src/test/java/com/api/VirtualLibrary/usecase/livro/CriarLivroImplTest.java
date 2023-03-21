package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.domain.entities.Livro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CriarLivroImplTest {

    @Test
    @DisplayName("Deve criar um livro")
    void criarLivro() {
        Livro livro = new Livro("titulo", new BigDecimal(10), "isbn");
        Assert.notNull(livro, "Livro não pode ser nulo");
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o livro for nulo")
    void livroNulo() {
        Livro livro = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Assert.notNull(livro, "Livro não pode ser nulo");
        });
    }
}