package com.api.VirtualLibrary.service.validator.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.Disponibilidade;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class VerificaSeEstaDisponivelExemplar implements Validator {

    @Autowired
    private EntityManager manager;

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
        Exemplar exemplar = manager.find(Exemplar.class, emprestimoRequest.getExemplarId());

        if (exemplar.getDisponibilidade().equals(Disponibilidade.alugado)) {
            errors.rejectValue("exemplarId", null,
                    "O exemplar não está disponível para empréstimo");
        }
    }
}
