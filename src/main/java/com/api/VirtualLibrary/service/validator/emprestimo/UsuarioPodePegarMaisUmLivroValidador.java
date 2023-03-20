package com.api.VirtualLibrary.service.validator.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.TipoDeCirculacao;
import com.api.VirtualLibrary.domain.enums.TipoUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UsuarioPodePegarMaisUmLivroValidador implements Validator {

    @PersistenceContext
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
        Usuario usuario = manager.find(Usuario.class, emprestimoRequest.getUsuarioId());
        Exemplar exemplar = manager.find(Exemplar.class, emprestimoRequest.getExemplarId());

        Assert.isTrue(usuario != null, "O usuario tem que existir");
        Assert.isTrue(exemplar != null, "O exemplar tem que existir");

        if (usuario.verificaTipoUsuario(TipoUsuario.padrao) && exemplar.eRestrito(TipoDeCirculacao.restrito)) {
            errors.reject("Esse tipo de usuario não pode pegar livros restritos");
        }

        if (usuario.verificaTipoUsuario(TipoUsuario.padrao) && usuario.aceitaMaisUmEmprestimo()) {
            errors.reject("Você pode ter apenas 5 emprestimos por vez");
        }
    }
}

