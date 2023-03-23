package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Livro;

import java.math.BigDecimal;

public class LivroResponse {
    private final String titulo;
    private final BigDecimal preco;
    private final String isbn;

    public LivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.isbn = livro.getIsbn();
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }
}
