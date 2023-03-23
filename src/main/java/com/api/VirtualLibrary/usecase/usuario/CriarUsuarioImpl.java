package com.api.VirtualLibrary.usecase.usuario;

import com.api.VirtualLibrary.adapters.input.request.UsuarioRequest;
import com.api.VirtualLibrary.adapters.output.repositories.UsuarioRepository;
import com.api.VirtualLibrary.domain.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioImpl implements CriarUsuario{

    private final UsuarioRepository usuarioRepository;

    public CriarUsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Usuario criarUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario (request.getNome(), request.getEmail(), request.getTipoUsuario());
        usuarioRepository.save(usuario);
        return usuario;
    }
}
