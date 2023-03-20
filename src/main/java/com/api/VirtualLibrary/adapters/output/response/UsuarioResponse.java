package com.api.VirtualLibrary.adapters.output.response;

import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponse {
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private List<EmprestimoResponse> emprestimos = new ArrayList<>();
    private List<DevolucaoResponse> devolucoes = new ArrayList<>();

    public UsuarioResponse(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.tipoUsuario = usuario.getTipoUsuario();
        this.emprestimos.addAll(usuario.getEmprestimos().stream().map(EmprestimoResponse::new).toList());
        this.devolucoes.addAll(usuario.getDevolucaos().stream().map(DevolucaoResponse::new).toList());
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

    public List<EmprestimoResponse> getEmprestimos() {
        return emprestimos;
    }

    public List<DevolucaoResponse> getDevolucoes() {
        return devolucoes;
    }
}
