package com.api.VirtualLibrary.adapters.output.repositories;

import com.api.VirtualLibrary.domain.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
