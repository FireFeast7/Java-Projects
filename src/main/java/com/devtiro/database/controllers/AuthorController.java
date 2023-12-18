package com.devtiro.database.controllers;

import com.devtiro.database.domain.dto.AuthorDto;
import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.repositories.AuthorRepository;
import com.devtiro.database.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private AuthorRepository authorRepository;
    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper,AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @DeleteMapping(path = "/authors")
    public void createAuthor() {
       authorRepository.deleteById(102L);
    }
    @GetMapping(path = "/authors")
    public String datadalo(){
        AuthorEntity authorEntity = AuthorEntity.builder()
                .age(23)
                .name("fdsf")
                .build();

        // Save the entity to the database
        authorRepository.save(authorEntity);
        Iterable<AuthorEntity> results = authorRepository.findAll();
        for (AuthorEntity author : results) {
            System.out.println(author);
        }
        // Optional: Print the saved entity's details for verification
        System.out.println("Data added to the database: " + authorEntity);
    return "Heelo";

    }
}
