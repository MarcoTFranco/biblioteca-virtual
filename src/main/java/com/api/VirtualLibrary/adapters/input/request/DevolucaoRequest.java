package com.api.VirtualLibrary.adapters.input.request;

import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.service.annotations.ExistsId;
import jakarta.validation.constraints.NotNull;

public class DevolucaoRequest {

    @NotNull
    @ExistsId(className = Usuario.class)
    private Long idUsuario;
    @NotNull
    @ExistsId(className = Emprestimo.class)
    private Long idEmprestimo;

    public DevolucaoRequest(@NotNull Long idUsuario,
                            @NotNull Long idEmprestimo) {
        this.idUsuario = idUsuario;
        this.idEmprestimo = idEmprestimo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

}
