package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarLivrosImpl implements ListarLivros {

    private LivroRepository livroRepository;

    public ListarLivrosImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }
}
