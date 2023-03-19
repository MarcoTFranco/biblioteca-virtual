package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Livro;

import java.math.BigDecimal;

public class LivroResponse {

    private Long id;
    private String titulo;
    private BigDecimal preco;
    private String isbn;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.isbn = livro.getIsbn();
    }

    public Long getId() {
        return id;
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
