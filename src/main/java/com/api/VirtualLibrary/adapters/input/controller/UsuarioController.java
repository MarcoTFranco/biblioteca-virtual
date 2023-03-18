package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.UsuarioRequest;
import com.api.VirtualLibrary.adapters.output.response.UsuarioResponse;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.usecase.usuario.CriarUsuarioImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class UsuarioController {

    private CriarUsuarioImpl dadosNovoUsuario;

    public UsuarioController(CriarUsuarioImpl dadosNovoUsuario) {
        this.dadosNovoUsuario = dadosNovoUsuario;
    }

    @PostMapping(value = "/usuarios")
    public ResponseEntity<UsuarioResponse> cadastroUsuario (@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = dadosNovoUsuario.criarUsuario(request);
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }

}
