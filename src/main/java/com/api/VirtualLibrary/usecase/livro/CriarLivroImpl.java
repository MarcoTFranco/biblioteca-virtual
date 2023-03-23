package com.api.VirtualLibrary.usecase.livro;

import com.api.VirtualLibrary.adapters.input.request.LivroRequest;
import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Livro;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CriarLivroImpl implements CriarLivro {

    private final LivroRepository livroRepository;

    public CriarLivroImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    @Transactional
    public Livro criarLivro(LivroRequest livroRequest) {
        Livro livro = new Livro (livroRequest.getTitulo(), livroRequest.getPreco(), livroRequest.getIsbn());
        livroRepository.save(livro);
        return livro;
    }
}
