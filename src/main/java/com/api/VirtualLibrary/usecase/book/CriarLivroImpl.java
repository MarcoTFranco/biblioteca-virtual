package com.api.VirtualLibrary.usecase.book;

import com.api.VirtualLibrary.adapters.input.request.LivroRequest;
import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Livro;
import org.springframework.stereotype.Service;

@Service
public class CriarLivroImpl implements CriarLivro {

    private LivroRepository livroRepository;

    public CriarLivroImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Livro criarLivro(LivroRequest livroRequest) {
        Livro livro = new Livro (livroRequest.getTitulo(), livroRequest.getPreco(), livroRequest.getIsbn());
        livroRepository.save(livro);
        return livro;
    }
}
