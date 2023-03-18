package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import jakarta.persistence.*;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoDeCirculacao tipoDeCirculacao;
    @ManyToOne
    private Livro livro;

    @Deprecated
    public Exemplar() {
    }

    public Exemplar(TipoDeCirculacao tipoDeCirculacao, Livro livro) {
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
}
