package com.api.VirtualLibrary.usecase.devolucao;

import com.api.VirtualLibrary.adapters.input.request.DevolucaoRequest;
import com.api.VirtualLibrary.domain.entities.Devolucao;

public interface CriarDevolucao {

    Devolucao criarDevolucao(DevolucaoRequest request);
}
