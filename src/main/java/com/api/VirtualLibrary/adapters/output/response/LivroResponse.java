package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Livro;

public class LivroResponse {

    private final Long id;
    private final String titulo;
    private final String preco;
    private final String isbn;

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

    public String getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }
}
