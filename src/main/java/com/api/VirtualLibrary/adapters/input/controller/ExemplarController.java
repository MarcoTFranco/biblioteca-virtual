package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.ExemplarRequest;
import com.api.VirtualLibrary.adapters.output.response.ExemplarResponse;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.usecase.exemplar.CriarExemplar;
import com.api.VirtualLibrary.usecase.exemplar.CriarExemplarImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ExemplarController {

    private final CriarExemplar dadosExemplar;

    public ExemplarController(CriarExemplarImpl dadosExemplar) {
        this.dadosExemplar = dadosExemplar;
    }

    @PostMapping("/livro/{isbn}/exemplares")
    public ResponseEntity<ExemplarResponse> cadastroExemplar(@PathVariable("isbn") String isbn,
                                                             @RequestBody ExemplarRequest request) {
        Exemplar exemplar = dadosExemplar.criarExemplar(isbn, request);
        ExemplarResponse exemplarResponse = new ExemplarResponse(exemplar);
        return ResponseEntity.ok().body(exemplarResponse);
    }

}
