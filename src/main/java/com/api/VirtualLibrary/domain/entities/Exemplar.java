package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.Disponibilidade;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

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
    private Disponibilidade disponibilidade;

    @Deprecated
    public Exemplar() {
    }

    public Exemplar(@NotNull TipoDeCirculacao tipoDeCirculacao,
                    @NotNull @Valid Livro livro) {
        this.tipoDeCirculacao = tipoDeCirculacao;
        this.livro = livro;
        this.disponibilidade = Disponibilidade.disponivel;
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

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean isRestrito(TipoDeCirculacao tipoDeCirculacao) {
        return this.tipoDeCirculacao.equals(tipoDeCirculacao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return tipoDeCirculacao == exemplar.tipoDeCirculacao && Objects.equals(livro, exemplar.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDeCirculacao, livro);
    }
}
