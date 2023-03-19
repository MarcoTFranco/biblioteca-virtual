package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;

public class ExemplarResponse {
    private Long id;
    private TipoDeCirculacao tipoDeCirculacao;
    private String tituloDolivro;

    public ExemplarResponse(Exemplar exemplar) {
        this.id = exemplar.getId();
        this.tipoDeCirculacao = exemplar.getTipoDeCirculacao();
        this.tituloDolivro = exemplar.getLivro().getTitulo();
    }

    public Long getId() {
        return id;
    }

    public TipoDeCirculacao getTipoDeCirculacao() {
        return tipoDeCirculacao;
    }

    public String getTituloDolivro() {
        return tituloDolivro;
    }
}
