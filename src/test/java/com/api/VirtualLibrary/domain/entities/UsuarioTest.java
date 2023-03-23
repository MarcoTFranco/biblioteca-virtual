package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;
    private Usuario pesquisador;

    @BeforeEach
    public void setUp(){
        usuario = new Usuario("nome", "email", TipoUsuario.padrao);
        pesquisador = new Usuario("João", "joao@gmail.com", TipoUsuario.pesquisador);
    }

    @ParameterizedTest
    @DisplayName("Deveria retornar true ou false de acordo com o tipo de usuário")
    @CsvSource({
            "true, pesquisador",
            "false, padrao"
    })
    void test1(boolean esperado, TipoUsuario tipoUsuario) {
        assertEquals(esperado, pesquisador.verificaTipoUsuario(tipoUsuario));
    }

    @Test
    @DisplayName("Deveria retornar true quando tiver espaço para mais um emprestimo")
    void test2() {
        Emprestimo emprestimo = new Emprestimo(usuario, new Exemplar(), 10);
        usuario.addEmprestimo(emprestimo);
        assertTrue(usuario.aceitaMaisUmEmprestimo());
    }

    @Test
    @DisplayName("Deveria retornar false quando não tiver espaço para mais um emprestimo")
    void test3() {
        List<Emprestimo> emprestimos = List.of(new Emprestimo(usuario, new Exemplar(), 10),
                new Emprestimo(usuario, new Exemplar(), 5),
                new Emprestimo(usuario, new Exemplar(), 7),
                new Emprestimo(usuario, new Exemplar(), 8),
                new Emprestimo(usuario, new Exemplar(), 9));
        for (Emprestimo emprestimo : emprestimos) {
            usuario.addEmprestimo(emprestimo);
        }
        assertFalse(usuario.aceitaMaisUmEmprestimo());
    }


    @Test
    @DisplayName("Deveria retornar false quando tiver um emprestimo em que não há atraso")
    void test4() {
        List<Emprestimo> emprestimos = List.of(
                new Emprestimo(usuario, new Exemplar(), 10),
                new Emprestimo(usuario, new Exemplar(), 5),
                new Emprestimo(usuario, new Exemplar(), 7));
        for (Emprestimo emprestimo : emprestimos) {
            usuario.addEmprestimo(emprestimo);
        }
        assertFalse(usuario.temEmprestimoEmAtraso());
    }

    @Test
    @DisplayName("Deveria retornar true quando tiver um emprestimo em que há atraso")
    void test5() {

        Emprestimo emprestimo = new Emprestimo(new Usuario(), new Exemplar(), 1);
        ReflectionTestUtils.setField(emprestimo, "horarioDoEmprestimo", LocalDate.now().minusDays(2));
        pesquisador.addEmprestimo(emprestimo);

        assertTrue(pesquisador.temEmprestimoEmAtraso());
    }

    @Test
    @DisplayName("Deveria retornar true quando o usuario tiver o emprestimo")
    void test6() {
        Emprestimo emprestimo = new Emprestimo(pesquisador, new Exemplar(), 1);
        pesquisador.addEmprestimo(emprestimo);

        assertTrue(pesquisador.temEmprestimo(emprestimo));
    }

    @Test
    @DisplayName("Deveria retornar false quando o usuario não tiver o emprestimo")
    void test7() {
        Emprestimo emprestimo = new Emprestimo(new Usuario(), new Exemplar(), 1);
        pesquisador.addEmprestimo(emprestimo);

        assertFalse(pesquisador.temEmprestimo(emprestimo));
    }

    @Test
    @DisplayName("Deveria retornar true quando o usuario tiver a devolução")
    void test8() {
        Emprestimo emprestimo = new Emprestimo(pesquisador, new Exemplar(), 1);
        Devolucao devolucao = new Devolucao(pesquisador, emprestimo);
        pesquisador.addDevolucao(devolucao);

        assertTrue(pesquisador.temDevolucao(emprestimo));
    }

    @Test
    @DisplayName("Deveria retornar false quando o usuario não tiver a devolução")
    void test9() {
        Emprestimo emprestimo = new Emprestimo(new Usuario(), new Exemplar(), 1);
        Devolucao devolucao = new Devolucao(pesquisador, emprestimo);
        pesquisador.addDevolucao(devolucao);

        assertFalse(pesquisador.temDevolucao(emprestimo));
    }


    @ParameterizedTest
    @DisplayName("Usuario padrao nao pode pegar livro restrito")
    @CsvSource({
            "true, livre",
            "false, restrito"
    })
    void test10(boolean esperado, TipoDeCirculacao tipoDeCirculacao) {
        assertEquals(esperado, usuario.podePegarLivro(tipoDeCirculacao));
    }

    @ParameterizedTest
    @DisplayName("Usuario pesquisador pode pegar qualquer livro")
    @CsvSource({
            "true, livre",
            "true, restrito"
    })
    void test11(boolean esperado, TipoDeCirculacao tipoDeCirculacao) {
        assertEquals(esperado, pesquisador.podePegarLivro(tipoDeCirculacao));
    }
}