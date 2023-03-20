package com.api.VirtualLibrary.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
public class Devolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @OneToOne
    private Emprestimo emprestimo;

    @Deprecated
    public Devolucao() {
    }

    public Devolucao(@NotNull @Valid Usuario usuario, @NotNull @Valid Emprestimo emprestimo) {
        this.usuario = usuario;
        this.emprestimo = emprestimo;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
}
