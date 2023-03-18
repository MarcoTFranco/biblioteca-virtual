package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.ExemplarRequest;
import com.api.VirtualLibrary.adapters.output.response.ExemplarResponse;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.usecase.exemplar.CriarExemplarImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
public class ExemplarController {

    private CriarExemplarImpl criarExemplar;

    public ExemplarController(CriarExemplarImpl criarExemplar) {
        this.criarExemplar = criarExemplar;
    }

    @PostMapping("livro/{isbn}/exemplares")
    public ResponseEntity<ExemplarResponse> cadastroExemplar(@PathVariable("isbn") String isbn,
                                                             @RequestBody ExemplarRequest request) {
        Exemplar exemplar = criarExemplar.criarExemplar(isbn, request);
        ExemplarResponse exemplarResponse = new ExemplarResponse(exemplar);
        return ResponseEntity.ok().body(exemplarResponse);
    }

}
