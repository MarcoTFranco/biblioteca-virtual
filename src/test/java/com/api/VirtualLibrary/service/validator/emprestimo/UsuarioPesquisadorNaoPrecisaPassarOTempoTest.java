package com.api.VirtualLibrary.service.validator.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsuarioPesquisadorNaoPrecisaPassarOTempoTest {

    private Usuario usuario;
    private Usuario pesquisador;
    private EmprestimoRequest emprestimoRequest;

    private UsuarioPesquisadorNaoPrecisaPassarOTempo usuarioPesquisadorNaoPrecisaPassarOTempo;

    @BeforeEach
    public void setUp() {

        usuarioPesquisadorNaoPrecisaPassarOTempo = new UsuarioPesquisadorNaoPrecisaPassarOTempo();
        usuario = new Usuario("nome", "email@gmail.com", TipoUsuario.padrao);
        pesquisador = new Usuario("pesquisador", "pesquisador@gmail.com", TipoUsuario.pesquisador);
        emprestimoRequest = new EmprestimoRequest(2, 1L, 1L);
    }

    @Test
    @DisplayName("Deveria continuar os mesmo dias para o usuario padrao")
    void test1() {
        usuarioPesquisadorNaoPrecisaPassarOTempo.verificaUsuarioEColocaOTempoLimite(usuario, emprestimoRequest);
        Assertions.assertEquals(2, emprestimoRequest.getDiasDeEmprestimo());
    }

    @Test
    @DisplayName("Deveria colocar 60 dias para o usuario pesquisador")
    void test2() {
        usuarioPesquisadorNaoPrecisaPassarOTempo.verificaUsuarioEColocaOTempoLimite(pesquisador, emprestimoRequest);
        Assertions.assertEquals(60, emprestimoRequest.getDiasDeEmprestimo());
    }

}