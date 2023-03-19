package com.api.VirtualLibrary.usecase.usuario;

import com.api.VirtualLibrary.adapters.output.repositories.UsuarioRepository;
import com.api.VirtualLibrary.domain.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarUsuarioImpl implements MostrarUsuario {

    private UsuarioRepository usuarioRepository;

    public MostrarUsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return usuarioRepository.findAll();
    }
}
