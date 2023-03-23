package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmprestimoTest {

    //LocalDate dataDeDevolucao = this.horarioDoEmprestimo.plusDays(this.diasDeEmprestimo);
    //        return dataDeDevolucao.isBefore(LocalDate.now());

    Exemplar exemplar = new Exemplar(TipoDeCirculacao.restrito, new Livro("titulo", BigDecimal.TEN, "123"));

    Usuario pesquisador = new Usuario("João", "joao@gmail.com", TipoUsuario.pesquisador);

    @Test
    @DisplayName("Deve retornar true se o emprestimo estiver em atraso")
    void test1() {
        Emprestimo emprestimo = new Emprestimo(pesquisador, exemplar, 1);
        ReflectionTestUtils.setField(emprestimo, "horarioDoEmprestimo", LocalDate.now().minusDays(2));
        assertTrue(emprestimo.estaEmAtraso());
    }

    @Test
    @DisplayName("Deve retornar false se o emprestimo estiver em atraso")
    void test2() {
        Emprestimo emprestimo = new Emprestimo(pesquisador, exemplar, 1);
        assertFalse(emprestimo.estaEmAtraso());
    }
}