package com.api.VirtualLibrary.adapters.input.controller;

import com.api.VirtualLibrary.adapters.input.request.EmprestimoRequest;
import com.api.VirtualLibrary.adapters.output.response.EmprestimoResponse;
import com.api.VirtualLibrary.domain.entities.Emprestimo;
import com.api.VirtualLibrary.service.validator.VerificaoBasicaEmprestimoValidator;
import com.api.VirtualLibrary.usecase.emprestimo.CriarEmprestimoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/emprestimos")
public class EmprestimoController {
    @Autowired
    VerificaoBasicaEmprestimoValidator verificaoBasicaEmprestimoValidator;
    @Autowired
    private CriarEmprestimoImpl dadosNovoEmprestimo;

    @InitBinder
    private void init(WebDataBinder binder) {
        binder.addValidators(verificaoBasicaEmprestimoValidator);
    }

    @PostMapping
    public ResponseEntity<EmprestimoResponse> cadastroEmprestimo(@RequestBody @Valid EmprestimoRequest request) {
        Emprestimo emprestimo = dadosNovoEmprestimo.criarEmprestimo(request);
        EmprestimoResponse emprestimoResponse = new EmprestimoResponse(emprestimo);
        return ResponseEntity.ok().body(emprestimoResponse);
    }

}
