package com.api.VirtualLibrary.service.validator;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPesquisadorNaoPrecisaPassarOTempo {

    public void verificaUsuarioEColocaOTempoLimite(Usuario usuario, EmprestimoRequest request) {
        if (usuario.verificaTipoUsuario(TipoUsuario.pesquisador)) {
            request.setDiasDeEmprestimo(60);
        }
    }
}
