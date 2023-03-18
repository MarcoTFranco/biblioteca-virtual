package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.domain.entities.Livro;

import java.util.List;

public interface ListarLivros {

    List<Livro> listarTodosLivros();

}
