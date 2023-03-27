package com.api.VirtualLibrary.usecase.emprestimo;

import com.api.VirtualLibrary.adapters.output.repositories.EmprestimoRepository;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MostrarEmprestimosImpl implements MostrarEmprestimos {

    private final EmprestimoRepository emprestimoRepository;

    public MostrarEmprestimosImpl(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

}
