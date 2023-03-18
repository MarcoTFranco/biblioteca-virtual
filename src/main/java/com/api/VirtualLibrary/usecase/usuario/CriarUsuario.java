package com.api.VirtualLibrary.usecase.usuario;

import com.api.VirtualLibrary.adapters.input.request.UsuarioRequest;
import com.api.VirtualLibrary.domain.entities.Usuario;

public interface CriarUsuario {

    Usuario criarUsuario (UsuarioRequest request);

}
