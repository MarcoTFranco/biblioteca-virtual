package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.UsuarioRequest;
import com.api.VirtualLibrary.adapters.output.response.UsuarioResponse;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.usecase.usuario.CriarUsuario;
import com.api.VirtualLibrary.usecase.usuario.ListarUsuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

    private CriarUsuario dadosNovoUsuario;

    private ListarUsuario listarUsuario;


    public UsuarioController(CriarUsuario dadosNovoUsuario, ListarUsuario listarUsuario) {
        this.dadosNovoUsuario = dadosNovoUsuario;
        this.listarUsuario = listarUsuario;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastroUsuario (@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = dadosNovoUsuario.criarUsuario(request);
        UsuarioResponse usuarioResponse = new UsuarioResponse(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> mostrarUsuarios () {
        List<UsuarioResponse> responseList = listarUsuario.mostrarUsuarios()
                .stream()
                .map(UsuarioResponse::new)
                .toList();
        return ResponseEntity.ok().body(responseList);
    }
}
