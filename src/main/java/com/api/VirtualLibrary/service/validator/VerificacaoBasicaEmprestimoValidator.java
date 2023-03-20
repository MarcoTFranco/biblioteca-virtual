package com.api.VirtualLibrary.service.validator;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.service.validator.emprestimo.TempoDeEntregaValidator;
import com.api.VirtualLibrary.service.validator.emprestimo.UsuarioPodePegarLivroRestritoValidador;
import com.api.VirtualLibrary.service.validator.emprestimo.UsuarioPodePegarMaisUmLivroValidador;
import com.api.VirtualLibrary.service.validator.emprestimo.VerificaSeEstaDisponivelExemplar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VerificacaoBasicaEmprestimoValidator implements Validator {

    @Autowired
    private UsuarioPodePegarLivroRestritoValidador usuarioPodePegarLivroRestritoValidador;

    @Autowired
    private UsuarioPodePegarMaisUmLivroValidador usuarioPodePegarMaisUmLivroValidador;

    @Autowired
    private TempoDeEntregaValidator tempoDeEntregaValidador;

    @Autowired
    VerificaSeEstaDisponivelExemplar verificaSeEstaDisponivelExemplar;

    @Override
    public boolean supports(Class<?> clazz) {
        return EmprestimoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        verificaSeEstaDisponivelExemplar.validate(target, errors);
        usuarioPodePegarLivroRestritoValidador.validate(target, errors);
        usuarioPodePegarMaisUmLivroValidador.validate(target, errors);
        tempoDeEntregaValidador.validate(target, errors);

    }
}
