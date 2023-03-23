package com.api.VirtualLibrary.usecase.repositories;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class FindRepositoryImpl implements FindRepository {

    private final EntityManager entityManager;

    public FindRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> T find(Class<T> classe, Long id) {
        return entityManager.find(classe, id);
    }
}