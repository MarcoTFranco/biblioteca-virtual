package com.api.VirtualLibrary.adapters.input.request;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class EmprestimoRequest {
    @Range(min = 1, max = 60)
    private Integer diasDeEmprestimo;
    @NotNull
    private Long usuarioId;
    @NotNull
    private Long exemplarId;

    @Deprecated
    public EmprestimoRequest() {
    }

    public EmprestimoRequest(@Range(min = 1, max = 60) Integer diasDeEmprestimo,
                             @NotNull Long usuarioId,
                             @NotNull Long exemplarId) {
        this.diasDeEmprestimo = diasDeEmprestimo;
        this.usuarioId = usuarioId;
        this.exemplarId = exemplarId;
    }

    public Integer getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    public void setDiasDeEmprestimo(Integer diasDeEmprestimo) {
        this.diasDeEmprestimo = diasDeEmprestimo;
    }

    public Long getExemplarId() {
        return exemplarId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}
