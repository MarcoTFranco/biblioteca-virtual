package com.api.VirtualLibrary.usecase.emprestimo;

import com.api.VirtualLibrary.domain.entities.Emprestimo;

import java.util.List;

public interface MostrarEmprestimos {

    List<Emprestimo> listarEmprestimos();
}
