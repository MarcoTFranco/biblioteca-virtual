package com.api.VirtualLibrary.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotNull
    @Positive
    private BigDecimal preco;
    @NotBlank
    private String isbn;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.MERGE)
    private List<Exemplar> exemplars = new ArrayList<>();

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotNull @Positive BigDecimal preco,
                 @NotBlank String isbn) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Exemplar> getExemplars() {
        return exemplars;
    }

    public void addExemplar(Exemplar exemplar) {
        this.exemplars.add(exemplar);
    }
}
