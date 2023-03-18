package com.api.VirtualLibrary.adapters.input.request;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import jakarta.validation.constraints.NotNull;

public class ExemplarRequest {

    @NotNull
    private TipoDeCirculacao tipoDeCirculacao;

    @Deprecated
    public ExemplarRequest() {
    }

    public ExemplarRequest(@NotNull TipoDeCirculacao tipoDeCirculacao) {
        this.tipoDeCirculacao = tipoDeCirculacao;
    }

    public TipoDeCirculacao getTipoDeCirculacao() {
        return tipoDeCirculacao;
    }

    public void setTipoDeCirculacao(TipoDeCirculacao tipoDeCirculacao) {
        this.tipoDeCirculacao = tipoDeCirculacao;
    }
}
