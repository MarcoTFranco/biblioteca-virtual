package com.api.VirtualLibrary.usecase.devolucao;

import com.api.VirtualLibrary.adapters.input.request.DevolucaoRequest;
import com.api.VirtualLibrary.adapters.output.repositories.DevolucaoRepository;
import com.api.VirtualLibrary.domain.entities.Devolucao;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.domain.entities.Usuario;
import com.api.VirtualLibrary.domain.enums.Disponibilidade;
import com.api.VirtualLibrary.usecase.repositories.FindRepository;
import com.api.VirtualLibrary.usecase.repositories.FindRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CriarDevolucaoImpl implements CriarDevolucao {

    private final FindRepository manager;

    private final DevolucaoRepository repository;

    public CriarDevolucaoImpl(FindRepositoryImpl manager, DevolucaoRepository repository) {
        this.manager = manager;
        this.repository = repository;
    }

    @Override
    @Transactional
    public Devolucao criarDevolucao(DevolucaoRequest request) {

        Usuario usuario = manager.find(Usuario.class, request.getIdUsuario());
        Emprestimo emprestimo = manager.find(Emprestimo.class, request.getIdEmprestimo());

        Assert.notNull(usuario, "Usuário não encontrado");
        Assert.notNull(emprestimo, "Emprestimo não encontrado");

        Devolucao devolucao = new Devolucao(usuario, emprestimo);
        repository.save(devolucao);
        usuario.addDevolucao(devolucao);
        emprestimo.getExemplar().setDisponibilidade(Disponibilidade.disponivel);

        return devolucao;
    }
}
