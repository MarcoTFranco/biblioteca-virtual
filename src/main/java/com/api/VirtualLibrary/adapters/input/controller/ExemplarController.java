package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.ExemplarRequest;
import com.api.VirtualLibrary.adapters.output.response.ExemplarResponse;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import com.api.VirtualLibrary.usecase.exemplar.CriarExemplar;
import com.api.VirtualLibrary.usecase.exemplar.MostrarExemplar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ExemplarController {

    private final CriarExemplar dadosExemplar;
    private final MostrarExemplar mostrarExemplar;

    public ExemplarController(CriarExemplar dadosExemplar, MostrarExemplar mostrarExemplar) {
        this.dadosExemplar = dadosExemplar;
        this.mostrarExemplar = mostrarExemplar;
    }

    @PostMapping("/livro/{isbn}/exemplares")
    public ResponseEntity<ExemplarResponse> cadastroExemplar(@PathVariable("isbn") String isbn,
                                                             @RequestBody ExemplarRequest request) {
        Exemplar exemplar = dadosExemplar.criarExemplar(isbn, request);
        ExemplarResponse exemplarResponse = new ExemplarResponse(exemplar);
        return ResponseEntity.ok().body(exemplarResponse);
    }

    @GetMapping("/exemplares")
    public ResponseEntity<List<ExemplarResponse>> listarExemplares() {
        List<ExemplarResponse> exemplares = mostrarExemplar.listarExemplares().stream()
                .map(ExemplarResponse::new)
                .toList();
        return ResponseEntity.ok().body(exemplares);
    }

}
