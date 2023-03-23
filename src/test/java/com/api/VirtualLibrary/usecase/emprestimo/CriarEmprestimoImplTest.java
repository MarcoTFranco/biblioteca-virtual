package com.api.VirtualLibrary.usecase.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.Disponibilidade;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

class CriarEmprestimoImplTest {

    private EmprestimoRequest emprestimoRequest;
    private Usuario usuario;
    private Exemplar exemplar;
    private EntityManager manager = Mockito.mock(EntityManager.class);

    @BeforeEach
    public void setUp() {
        emprestimoRequest = new EmprestimoRequest(15, 1L, 1L);
        usuario = new Usuario("usuario", "usuario@gmail.com", TipoUsuario.padrao);
        exemplar = new Exemplar(TipoDeCirculacao.livre, new Livro("titulo", BigDecimal.TEN, "12345"));
        Mockito.when(manager.find(Usuario.class, 1L)).thenReturn(usuario);
        Mockito.when(manager.find(Exemplar.class, 1L)).thenReturn(exemplar);
    }

    @Test
    @DisplayName("deveria retornar um usuario valido")
    public void test1() {
        Usuario usuario1 = manager.find(Usuario.class, 1L);
        Assertions.assertNotNull(usuario1);
    }

    @Test
    @DisplayName("deveria retornar um exemplar valido")
    public void test2() {
        Exemplar exemplar1 = manager.find(Exemplar.class, 1L);
        Assertions.assertNotNull(exemplar1);
    }

    @Test
    @DisplayName("deveria criar um emprestimo")
    public void test3() {
        Exemplar exemplar1 = manager.find(Exemplar.class, 1L);
        Usuario usuario1 = manager.find(Usuario.class, 1L);
        Emprestimo emprestimo = new Emprestimo(usuario1, exemplar1, emprestimoRequest.getDiasDeEmprestimo());
        Assertions.assertNotNull(emprestimo);
    }

    @Test
    @DisplayName("deveria add o emprestimo a um usuario")
    public void test4() {
        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, emprestimoRequest.getDiasDeEmprestimo());
        usuario.addEmprestimo(emprestimo);
        Assertions.assertEquals(usuario.getEmprestimos(), List.of(emprestimo));
    }

    @Test
    @DisplayName("deveria mudar a disponibilidade do exemplar")
    public void test5() {
        exemplar.setDisponibilidade(Disponibilidade.alugado);
        Assertions.assertSame(exemplar.getDisponibilidade(), Disponibilidade.alugado);
    }


}