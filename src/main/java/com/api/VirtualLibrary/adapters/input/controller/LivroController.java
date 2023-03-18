package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.LivroRequest;
import com.api.VirtualLibrary.adapters.output.response.LivroResponse;
import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.usecase.livro.CriarLivroImpl;
import com.api.VirtualLibrary.usecase.livro.ListarLivrosImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/livros")
public class LivroController {

    private CriarLivroImpl dadosNovoLivro;

    private ListarLivrosImpl listarLivro;

    public LivroController(CriarLivroImpl dadosNovoLivro, ListarLivrosImpl listarLivro) {
        this.dadosNovoLivro = dadosNovoLivro;
        this.listarLivro = listarLivro;
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastroLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = dadosNovoLivro.criarLivro(livroRequest);
        LivroResponse livroResponse = new LivroResponse (livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponse);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listarLivros () {
        List<LivroResponse> livroResponses = listarLivro.listarTodosLivros()
                .stream()
                .map(LivroResponse::new)
                .toList();
        return ResponseEntity.ok().body(livroResponses);
    }

}
