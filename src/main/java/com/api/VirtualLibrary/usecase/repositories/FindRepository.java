package com.api.VirtualLibrary.usecase.repositories;

public interface FindRepository {

    <T> T find(Class<T> classe, Long id);

}
