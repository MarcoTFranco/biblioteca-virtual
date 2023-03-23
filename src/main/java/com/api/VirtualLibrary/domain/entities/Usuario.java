package com.api.VirtualLibrary.domain.entities;

import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private TipoUsuario tipoUsuario;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Emprestimo> emprestimos = new ArrayList<>();
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Devolucao> devolucaos = new ArrayList<>();

    @Deprecated
    public Usuario() {
    }

    public Usuario(@NotBlank String nome,
                   @Email @NotBlank String email,
                   @NotNull TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Devolucao> getDevolucaos() {
        return devolucaos;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void addDevolucao(Devolucao devolucao) {
        this.devolucaos.add(devolucao);
    }

    public boolean verificaTipoUsuario(TipoUsuario tipoUsuario) {
        return this.tipoUsuario.equals(tipoUsuario);
    }

    public boolean aceitaMaisUmEmprestimo() {
        return tipoUsuario.podeEmprestar(this);
    }

    public boolean temEmprestimoEmAtraso() {
        return emprestimos.stream().anyMatch(Emprestimo::estaEmAtraso);
    }

    public boolean usuarioEDono(Usuario usuario) {
        return this.equals(usuario);
    }

    public boolean temEmprestimo(Emprestimo emprestimo) {
        if (usuarioEDono(emprestimo.getUsuario())) {
            return this.emprestimos.stream()
                    .anyMatch(emprestimo1 -> emprestimo1.equals(emprestimo));
        }
        return false;
    }

    public boolean temDevolucao(Emprestimo emprestimo) {
        if (usuarioEDono(emprestimo.getUsuario())) {
            return this.devolucaos.stream()
                    .anyMatch(devolucao -> devolucao.getEmprestimo().equals(emprestimo));
        }
        return false;
    }

    public boolean podePegarLivro(TipoDeCirculacao tipoDeCirculacao) {
        return tipoUsuario.podePegar(tipoDeCirculacao);
    }
}
