package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;

public class ExemplarResponse {
    private final TipoDeCirculacao tipoDeCirculacao;
    private final String tituloDolivro;

    public ExemplarResponse(Exemplar exemplar) {
        this.tipoDeCirculacao = exemplar.getTipoDeCirculacao();
        this.tituloDolivro = exemplar.getLivro().getTitulo();
    }


    public TipoDeCirculacao getTipoDeCirculacao() {
        return tipoDeCirculacao;
    }

    public String getTituloDolivro() {
        return tituloDolivro;
    }
}
