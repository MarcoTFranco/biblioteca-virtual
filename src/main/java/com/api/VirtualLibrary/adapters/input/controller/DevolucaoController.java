package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.DevolucaoRequest;
import com.api.VirtualLibrary.adapters.output.response.DevolucaoResponse;
import com.api.VirtualLibrary.domain.entities.Devolucao;
import com.api.VirtualLibrary.service.validator.VerificacaoBasicaDevolucaoValidator;
import com.api.VirtualLibrary.usecase.devolucao.CriarDevolucao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/api/v1")
public class DevolucaoController {

    private CriarDevolucao dadosDevolucao;

    private VerificacaoBasicaDevolucaoValidator verificacaoBasicaDevolucaoValidator;


    public DevolucaoController(CriarDevolucao dadosDevolucao,
                               VerificacaoBasicaDevolucaoValidator verificacaoBasicaDevolucaoValidator) {
        this.dadosDevolucao = dadosDevolucao;
        this.verificacaoBasicaDevolucaoValidator = verificacaoBasicaDevolucaoValidator;
    }

    @InitBinder
    private void init(WebDataBinder binder) {
        binder.addValidators(verificacaoBasicaDevolucaoValidator);
    }


    @PostMapping(value = "/devolucao")
    public ResponseEntity<DevolucaoResponse> devolverLivro(@RequestBody @Valid DevolucaoRequest devolucaoRequest) {
        Devolucao devolucao = dadosDevolucao.criarDevolucao(devolucaoRequest);
        DevolucaoResponse devolucaoResponse = new DevolucaoResponse(devolucao);
        return ResponseEntity.ok().body(devolucaoResponse);
    }

}
