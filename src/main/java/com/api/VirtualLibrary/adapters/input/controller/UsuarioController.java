package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.UsuarioRequest;
import com.api.VirtualLibrary.adapters.output.response.UsuarioResponse;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.usecase.usuario.CriarUsuarioImpl;
import com.api.VirtualLibrary.usecase.usuario.MostrarUsuarioImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

    private CriarUsuarioImpl dadosNovoUsuario;

    private MostrarUsuarioImpl mostrarUsuario;


    public UsuarioController(CriarUsuarioImpl dadosNovoUsuario, MostrarUsuarioImpl mostrarUsuario) {
        this.dadosNovoUsuario = dadosNovoUsuario;
        this.mostrarUsuario = mostrarUsuario;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastroUsuario (@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = dadosNovoUsuario.criarUsuario(request);
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> mostrarUsuarios () {
        List<UsuarioResponse> responseList = mostrarUsuario.mostrarUsuarios()
                .stream()
                .map(UsuarioResponse::new)
                .toList();
        return ResponseEntity.ok().body(responseList);
    }
}
