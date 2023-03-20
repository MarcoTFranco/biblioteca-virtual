package com.api.VirtualLibrary.service.validator.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class TempoDeEntregaValidator implements Validator {
    private EntityManager manager;

    public TempoDeEntregaValidator(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EmprestimoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EmprestimoRequest emprestimoRequest = (EmprestimoRequest) target;
        Usuario usuario = manager.find(Usuario.class, emprestimoRequest.getUsuarioId());

        Assert.state(Objects.nonNull(usuario), "O usuario tem que existir");

        if (usuario.temEmprestimoEmAtraso()) {
            errors.rejectValue("dataDeDevolucao", null,
                    "A data de devolução não pode ser menor que a data de empréstimo");
        }

    }
}
