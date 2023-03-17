package com.api.VirtualLibrary.adapters.output.repositories;

import com.api.VirtualLibrary.domain.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
