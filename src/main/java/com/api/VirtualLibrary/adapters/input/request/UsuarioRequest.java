package com.api.VirtualLibrary.adapters.input.request;

import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private TipoUsuario tipoUsuario;

    @Deprecated
    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotBlank String nome,
                          @Email @NotBlank String email,
                          @NotNull TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
