package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private Usuario usuario;
    @OneToOne
    @NotNull
    private Exemplar exemplar;
    @Range(min = 1, max = 60)
    private Integer diasDeEmprestimo;
    @FutureOrPresent
    private LocalDate horarioDoEmprestimo;

    @Deprecated
    public Emprestimo() {
    }

    public Emprestimo(@NotNull @Valid Usuario usuario,
                      @NotNull @Valid Exemplar exemplar,
                      @Range(min = 1, max = 60) Integer diasDeEmprestimo) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.diasDeEmprestimo = diasDeEmprestimo;
        this.horarioDoEmprestimo = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Integer getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    public LocalDate getHorarioDoEmprestimo() {
        return horarioDoEmprestimo;
    }

    public LocalDate dataDeDevolucao() {
        return this.horarioDoEmprestimo.plusDays(this.diasDeEmprestimo);
    }

    public boolean estaEmAtraso() {
        return this.dataDeDevolucao().isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id.equals(that.id) && usuario.equals(that.usuario) && exemplar.equals(that.exemplar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, exemplar);
    }
}