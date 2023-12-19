package com.devtiro.database.services;

import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.domain.entities.BookEntity;

public interface BookService {
    BookEntity save(String isbn ,BookEntity bookEntity);
}
