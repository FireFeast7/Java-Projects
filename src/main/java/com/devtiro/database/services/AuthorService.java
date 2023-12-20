package com.devtiro.database.services;

import com.devtiro.database.domain.entities.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

    boolean doesExists(Long id);

    AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

    void deletebyId(Long id);
}
