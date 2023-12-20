package com.devtiro.database.controllers;

import com.devtiro.database.domain.dto.AuthorDto;
import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.repositories.AuthorRepository;
import com.devtiro.database.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }
    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }
    @GetMapping(path = "/authors")
    public List<AuthorDto> listAuthors(){
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream().
                map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

        @GetMapping(path = "/authors/{id}")
        public ResponseEntity<AuthorDto> getSingleAuthor(
                @PathVariable("id") Long id){
            Optional<AuthorEntity> author = authorService.findById(id);
            return author.map(authorEntity ->{
                AuthorDto authorDto1 = authorMapper.mapTo(authorEntity);
                return new ResponseEntity<>(authorDto1,HttpStatus.OK);
            }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PutMapping(path = "authors/{id}")
        public ResponseEntity<AuthorDto> authorfullupdate(
                @PathVariable("id") Long id ,
                @RequestBody AuthorDto authorDto){
            if(!authorService.doesExists(id)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            authorDto.setId(id);
            AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
            AuthorEntity savedauthorEntity = authorService.save(authorEntity);
            return new ResponseEntity<>(authorMapper.mapTo(savedauthorEntity),HttpStatus.OK);
    }

    @PatchMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> partialUpdate(
            @PathVariable("id") Long id,
            @RequestBody AuthorDto authordto
    ){
            if(!authorService.doesExists(id)){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            AuthorEntity authorEntity = authorMapper.mapFrom(authordto);
            AuthorEntity updatedAuthorEntity = authorService.partialUpdate(id,authorEntity);
            return new ResponseEntity<>(authorMapper.mapTo(updatedAuthorEntity),HttpStatus.OK);
    }

    @DeleteMapping(path = "/authors/{id}")
    public ResponseEntity deleteAuthor(
            @PathVariable("id") Long id){
        if(!authorService.doesExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorService.deletebyId(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
