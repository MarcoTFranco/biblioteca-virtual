package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.adapters.input.request.LivroRequest;
import com.api.VirtualLibrary.domain.entities.Livro;

public interface CriarLivro {

    Livro criarLivro(LivroRequest livroRequest);

}
