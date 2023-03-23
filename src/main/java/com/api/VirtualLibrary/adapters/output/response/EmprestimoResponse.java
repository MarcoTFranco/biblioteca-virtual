package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Emprestimo;

import java.time.LocalDate;

public class EmprestimoResponse {
    private final String nomeUsuario;
    private final ExemplarResponse exemplar;
    private final Integer diasDeEmprestimo;
    private final LocalDate horarioDoEmprestimo;

    public EmprestimoResponse(Emprestimo emprestimo) {
        this.nomeUsuario = emprestimo.getUsuario().getNome();
        this.exemplar = new ExemplarResponse(emprestimo.getExemplar());
        this.diasDeEmprestimo = emprestimo.getDiasDeEmprestimo();
        this.horarioDoEmprestimo = emprestimo.getHorarioDoEmprestimo();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public ExemplarResponse getExemplar() {
        return exemplar;
    }

    public Integer getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    public LocalDate getHorarioDoEmprestimo() {
        return horarioDoEmprestimo;
    }
}
