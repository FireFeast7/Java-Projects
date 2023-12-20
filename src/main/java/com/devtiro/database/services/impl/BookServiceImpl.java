package com.devtiro.database.services.impl;

import com.devtiro.database.domain.entities.BookEntity;
import com.devtiro.database.repositories.BookRepository;
import com.devtiro.database.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public BookEntity save(String isbn ,BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findById(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public boolean doesExists(String isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public BookEntity partialUpdate(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.findById(isbn).map(existingBook -> {
        Optional.ofNullable(bookEntity.getTitle()).ifPresent(existingBook::setTitle);
        return bookRepository.save(bookEntity);
        }).orElseThrow(()-> new RuntimeException("Book Does Not Exist"));
    }

    @Override
    public void deletebook(String isbn) {
        bookRepository.deleteById(isbn);
    }
}
