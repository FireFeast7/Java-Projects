package com.devtiro.database.services;

import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.domain.entities.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity save(String isbn ,BookEntity bookEntity);

    List<BookEntity> findAll();

    Optional<BookEntity> findById(String isbn);

    boolean doesExists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void deletebook(String isbn);
}
