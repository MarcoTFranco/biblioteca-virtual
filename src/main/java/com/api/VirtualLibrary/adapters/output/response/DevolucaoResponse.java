package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Devolucao;

public class DevolucaoResponse {

    private String nomeUsuario;
    private String nomeLivro;

    public DevolucaoResponse(Devolucao devolucao) {
        this.nomeUsuario = devolucao.getUsuario().getNome();
        this.nomeLivro = devolucao.getEmprestimo().getExemplar().getLivro().getTitulo();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }
}
