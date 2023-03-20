package com.api.VirtualLibrary.service.validator.devolucao;

import com.api.VirtualLibrary.adapters.input.request.DevolucaoRequest;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SoPodeDevolver1VezValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return DevolucaoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        DevolucaoRequest devolucaoRequest = (DevolucaoRequest) target;

        Usuario usuario = manager.find(Usuario.class, devolucaoRequest.getIdUsuario());
        Emprestimo emprestimo = manager.find(Emprestimo.class, devolucaoRequest.getIdEmprestimo());

        if (usuario.existeDevolucao(emprestimo)) {
            errors.rejectValue("idEmprestimo", null,
                    "Este empréstimo já foi devolvido");
        }
    }
}
