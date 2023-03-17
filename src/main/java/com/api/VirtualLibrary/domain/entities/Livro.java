package com.api.VirtualLibrary.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String preco;
    private String isbn;

    public Livro(String titulo, String preco, String isbn) {
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
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
