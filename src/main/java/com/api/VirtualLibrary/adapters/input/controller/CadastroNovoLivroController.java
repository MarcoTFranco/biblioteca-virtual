package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.LivroRequest;
import com.api.VirtualLibrary.adapters.output.response.LivroResponse;
import com.api.VirtualLibrary.domain.entities.Livro;
import com.api.VirtualLibrary.usecase.book.CriarLivroImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/livros")
public class CadastroNovoLivroController {

    private CriarLivroImpl dadosNovoLivro;

    public CadastroNovoLivroController(CriarLivroImpl dadosNovoLivro) {
        this.dadosNovoLivro = dadosNovoLivro;
    }

    @PostMapping
    public ResponseEntity<LivroResponse> cadastroLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = dadosNovoLivro.criarLivro(livroRequest);
        LivroResponse livroResponse = new LivroResponse (livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroResponse);
    }

}
