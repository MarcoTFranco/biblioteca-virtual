package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DevolucaoTest {

    Exemplar exemplar = new Exemplar(TipoDeCirculacao.restrito, new Livro("titulo", BigDecimal.TEN, "123"));
    Usuario pesquisador = new Usuario("João", "joao@gmail.com", TipoUsuario.pesquisador);
    Emprestimo emprestimo = new Emprestimo(pesquisador, exemplar, 1);

    @Test
    @DisplayName("Deveria criar um devolucao")
    void test1() {
        Devolucao devolucao = new Devolucao(pesquisador, emprestimo);
        assertNotNull(devolucao);
    }

}