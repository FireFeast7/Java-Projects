package com.devtiro.database.services.impl;

import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.repositories.AuthorRepository;
import com.devtiro.database.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return (List<AuthorEntity>) authorRepository.findAll();
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean doesExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity) {
        authorEntity.setId(id);
        return authorRepository.findById(id).map(existingEntity -> {
        Optional.ofNullable(authorEntity.getName()).ifPresent(existingEntity::setName);
        Optional.ofNullable(authorEntity.getAge()).ifPresent(existingEntity::setAge);
        return authorRepository.save(existingEntity);
        }).orElseThrow(()->new RuntimeException("Author Does Not Exist"));

    }

    @Override
    public void deletebyId(Long id) {
        authorRepository.deleteById(id);
    }
}
