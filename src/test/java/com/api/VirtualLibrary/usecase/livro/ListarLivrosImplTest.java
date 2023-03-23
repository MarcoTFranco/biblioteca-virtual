package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

class ListarLivrosImplTest {

    private final LivroRepository livroRepository = Mockito.mock(LivroRepository.class);

    private static Stream<List<Livro>> generator() {
        return Stream.of(
                List.of(
                        new Livro("titulo", BigDecimal.TEN, "isbn"),
                        new Livro("titulo2", BigDecimal.TEN, "isbn2"),
                        new Livro("titulo3", BigDecimal.TEN, "isbn3")));
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia de livros")
    void test1() {
        Mockito.when(livroRepository.findAll()).thenReturn(List.of());
        Assertions.assertEquals(List.of(), livroRepository.findAll());
    }

    @ParameterizedTest
    @DisplayName("Deve retornar uma lista de livros")
    @MethodSource("generator")
    void test2(List<Livro> livros) {
        Mockito.when(livroRepository.findAll()).thenReturn(livros);
        Assertions.assertEquals(livros, livroRepository.findAll());
    }
}