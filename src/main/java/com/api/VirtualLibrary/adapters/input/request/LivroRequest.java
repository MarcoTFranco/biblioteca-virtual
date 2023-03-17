package com.api.VirtualLibrary.adapters.input.request;

import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.service.annotations.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class LivroRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String preco;
    @NotBlank
    @UniqueValue(fieldName = "isbn", className = Livro.class)
    private String isbn;
    @Deprecated
    public LivroRequest() {
    }

    public LivroRequest(String titulo, String preco, String isbn) {
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
