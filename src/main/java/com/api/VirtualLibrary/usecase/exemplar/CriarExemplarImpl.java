package com.api.VirtualLibrary.usecase.exemplar;

import com.api.VirtualLibrary.adapters.input.request.ExemplarRequest;
import com.api.VirtualLibrary.adapters.output.repositories.ExemplarRepository;
import com.api.VirtualLibrary.adapters.output.repositories.LivroRepository;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.domain.entities.Livro;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CriarExemplarImpl implements CriarExemplar {

    private ExemplarRepository exemplarRepository;

    private LivroRepository livroRepository;

    public CriarExemplarImpl(ExemplarRepository exemplarRepository, LivroRepository livroRepository) {
        this.exemplarRepository = exemplarRepository;
        this.livroRepository = livroRepository;
    }

    @Override
    @Transactional
    public Exemplar criarExemplar(String isbn, ExemplarRequest request) {

        Livro livro = livroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Exemplar exemplar = new Exemplar(request.getTipoDeCirculacao(), livro);

        exemplarRepository.save(exemplar);
        return exemplar;
    }
}
