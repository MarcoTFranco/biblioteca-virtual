package com.api.VirtualLibrary.usecase.emprestimo;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.domain.entities.Emprestimo;

public interface CriarEmprestimo {

    Emprestimo criarEmprestimo(EmprestimoRequest request);

}
