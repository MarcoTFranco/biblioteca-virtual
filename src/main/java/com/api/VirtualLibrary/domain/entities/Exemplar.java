package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private TipoDeCirculacao tipoDeCirculacao;
    @ManyToOne
    @NotNull
    private Livro livro;

    @Deprecated
    public Exemplar() {
    }

    public Exemplar(@NotNull TipoDeCirculacao tipoDeCirculacao,
                    @NotNull @Valid Livro livro) {
        this.tipoDeCirculacao = tipoDeCirculacao;
        this.livro = livro;
    }


    public Long getId() {
        return id;
    }

    public TipoDeCirculacao getTipoDeCirculacao() {
        return tipoDeCirculacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean eRestrito(TipoDeCirculacao tipoDeCirculacao) {
        return this.tipoDeCirculacao.equals(tipoDeCirculacao);
    }
}
