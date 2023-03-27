package com.api.VirtualLibrary.usecase.exemplar;

import com.api.VirtualLibrary.adapters.output.repositories.ExemplarRepository;
import com.api.VirtualLibrary.domain.entities.Exemplar;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MostrarExemplarImpl implements MostrarExemplar {

    private final ExemplarRepository exemplarRepository;

    public MostrarExemplarImpl(ExemplarRepository exemplarRepository) {
        this.exemplarRepository = exemplarRepository;
    }

    public List<Exemplar> listarExemplares() {
        return exemplarRepository.findAll();
    }
}
