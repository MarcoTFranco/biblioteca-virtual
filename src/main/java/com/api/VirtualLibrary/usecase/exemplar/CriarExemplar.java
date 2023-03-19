package com.api.VirtualLibrary.usecase.exemplar;

import com.api.VirtualLibrary.adapters.input.request.ExemplarRequest;
import com.api.VirtualLibrary.domain.entities.Exemplar;

public interface CriarExemplar {

    Exemplar criarExemplar(String isbn, ExemplarRequest request);
}
