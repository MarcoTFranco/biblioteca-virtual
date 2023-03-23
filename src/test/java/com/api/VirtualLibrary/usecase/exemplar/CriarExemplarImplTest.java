package com.api.VirtualLibrary.usecase.exemplar;

import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

class CriarExemplarImplTest {

    private final LivroRepository livroRepository = Mockito.mock(LivroRepository.class);

    @Test
    @DisplayName("Deve lançar uma exceção quando o livro não for encontrado")
    void test1() {

        Mockito.when(livroRepository.findByIsbn("123")).thenReturn(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            livroRepository.findByIsbn("123").get();
        });

    }

    @Test
    @DisplayName("Deve criar um exemplar")
    void test2() {
        Mockito.when(livroRepository.findByIsbn("123"))
                .thenReturn(Optional.of((new Livro("123", BigDecimal.TEN, "123"))));
        Livro livro = livroRepository.findByIsbn("123").get();
        Exemplar exemplar = new Exemplar(TipoDeCirculacao.restrito, livro);
        Assertions.assertNotNull(exemplar);
    }


}