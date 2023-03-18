package com.api.VirtualLibrary.adapters.output.repositories;

import com.api.VirtualLibrary.domain.entities.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}
