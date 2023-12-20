package com.devtiro.database.controllers;

import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.domain.entities.BookEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private BookService bookService;
    private Mapper<BookEntity,BookDto> bookMapper;

    public BookController(Mapper<BookEntity,BookDto> bookMapper,BookService bookService){
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }
    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookdto){
        BookEntity bookEntity = bookMapper.mapFrom(bookdto);
        boolean bookExists = bookService.doesExists(isbn);
        BookEntity savedEntity = bookService.save(isbn,bookEntity);
        BookDto savedbookDto =  bookMapper.mapTo(savedEntity);
        if(bookExists){
            return new ResponseEntity<>(savedbookDto,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(savedbookDto,HttpStatus.CREATED);
        }
    }
    @GetMapping(path = "/books")
    public List<BookDto> getBooks(){
        List<BookEntity> bookEntities = bookService.findAll();
        return bookEntities.stream().map(bookMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> getBookbyISBN(@PathVariable("isbn") String isbn){
        Optional<BookEntity> bookEntity = bookService.findById(isbn);
        return bookEntity.map(bookEntity1 -> {
            BookDto bookDto = bookMapper.mapTo(bookEntity1);
            return new ResponseEntity<>(bookDto,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> partialUpdate(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDto bookDto
    ){
        if(!bookService.doesExists(isbn)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            BookEntity bookEntity = bookMapper.mapFrom(bookDto);
            BookEntity updateBookEntity = bookService.partialUpdate(isbn ,bookEntity);
            return new ResponseEntity<>(bookMapper.mapTo(updateBookEntity),HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn){
        if(!bookService.doesExists(isbn)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        bookService.deletebook(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
