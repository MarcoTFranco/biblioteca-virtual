package com.api.VirtualLibrary.adapters.input.request;

import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.service.annotations.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class LivroRequest {
    @NotBlank
    private String titulo;
    @NotNull
    @Positive
    private BigDecimal preco;
    @NotBlank
    @UniqueValue(fieldName = "isbn", className = Livro.class)
    private String isbn;
    @Deprecated
    public LivroRequest() {
    }

    public LivroRequest(@NotBlank String titulo,
                        @NotNull @Positive BigDecimal preco,
                        @NotBlank String isbn) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
