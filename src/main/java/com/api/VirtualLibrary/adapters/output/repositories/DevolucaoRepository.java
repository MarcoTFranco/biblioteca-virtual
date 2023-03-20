package com.api.VirtualLibrary.adapters.output.repositories;

import com.api.VirtualLibrary.domain.entities.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {
}
