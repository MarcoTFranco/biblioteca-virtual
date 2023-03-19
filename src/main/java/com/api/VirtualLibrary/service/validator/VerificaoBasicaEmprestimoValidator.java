package com.api.VirtualLibrary.service.validator;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VerificaoBasicaEmprestimoValidator implements Validator {

    @Autowired
    private UsuarioPodePegarLivroRestritoValidador usuarioPodePegarLivroRestritoValidador;

    @Autowired
    private UsuarioPodePegarMaisUmLivroValidador usuarioPodePegarMaisUmLivroValidador;

    @Override
    public boolean supports(Class<?> clazz) {
        return EmprestimoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        usuarioPodePegarLivroRestritoValidador.validate(target, errors);
        usuarioPodePegarMaisUmLivroValidador.validate(target, errors);

    }
}
