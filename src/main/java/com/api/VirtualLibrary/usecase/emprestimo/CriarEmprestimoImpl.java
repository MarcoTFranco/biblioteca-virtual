package com.api.VirtualLibrary.usecase.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.adapters.output.repositories.EmprestimoRepository;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.Disponibilidade;
import com.api.VirtualLibrary.service.validator.emprestimo.UsuarioPesquisadorNaoPrecisaPassarOTempo;
import com.api.VirtualLibrary.usecase.repositories.FindRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CriarEmprestimoImpl implements CriarEmprestimo {

    private final UsuarioPesquisadorNaoPrecisaPassarOTempo usuarioPesquisadorNaoPrecisaPassarOTempo;

    private final FindRepository manager;

    private final EmprestimoRepository emprestimoRepository;

    public CriarEmprestimoImpl(UsuarioPesquisadorNaoPrecisaPassarOTempo usuarioPesquisadorNaoPrecisaPassarOTempo,
                               FindRepository manager,
                               EmprestimoRepository emprestimoRepository) {
        this.usuarioPesquisadorNaoPrecisaPassarOTempo = usuarioPesquisadorNaoPrecisaPassarOTempo;
        this.manager = manager;
        this.emprestimoRepository = emprestimoRepository;
    }

    @Override
    @Transactional
    public Emprestimo criarEmprestimo(EmprestimoRequest request) {
        Usuario usuario = manager.find(Usuario.class, request.getUsuarioId());
        Exemplar exemplar = manager.find(Exemplar.class, request.getExemplarId());

        Assert.isTrue(usuario != null, "O usuario tem que existir");
        Assert.isTrue(exemplar != null, "O exemplar tem que existir");

        usuarioPesquisadorNaoPrecisaPassarOTempo.verificaUsuarioEColocaOTempoLimite(usuario, request);

        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, request.getDiasDeEmprestimo());
        emprestimoRepository.save(emprestimo);
        usuario.addEmprestimo(emprestimo);
        exemplar.setDisponibilidade(Disponibilidade.alugado);

        return emprestimo;

    }

}
