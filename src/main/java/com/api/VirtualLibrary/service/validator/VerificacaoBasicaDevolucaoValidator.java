package com.api.VirtualLibrary.service.validator;

import com.api.VirtualLibrary.adapters.input.request.DevolucaoRequest;
import com.api.VirtualLibrary.service.validator.devolucao.SoPodeDevolver1VezValidator;
import com.api.VirtualLibrary.service.validator.devolucao.SomenteODonoDoEmprestimoPodeDevolverValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VerificacaoBasicaDevolucaoValidator implements Validator {
    @Autowired
    private SomenteODonoDoEmprestimoPodeDevolverValidator somenteODonoDoEmprestimoPodeDevolverValidator;
    @Autowired
    private SoPodeDevolver1VezValidator soPodeDevolver1VezValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return DevolucaoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        somenteODonoDoEmprestimoPodeDevolverValidator.validate(target, errors);
        soPodeDevolver1VezValidator.validate(target, errors);

    }
}
