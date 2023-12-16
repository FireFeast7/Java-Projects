package com.project.quickstart.dao.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    BookDaoImpl underTest;
    @Test
    public void createBook(){
        Book book = Book.builder()
                .author_id(1L)
                .isbn("1800-6969-6969")
                .title("The Monk who Sold his Ferrari")
                .build();
        underTest.create(book);
        verify(jdbcTemplate).update(eq("INSERT INTO books (author_id, isbn, title) VALUES (?, ?, ?)")
                ,eq(1L),eq("1800-6969-6969"),eq("The Monk who Sold his Ferrari"));
    }
    @Test
    public void readOne(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("select author_id, isbn, title from books where author_id = ?"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq(1L));
    }
    @Test
    public void findMany(){
        underTest.findMany();
        verify(jdbcTemplate).query(
                eq("SELECT author_id, isbn, title from books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }
    @Test
    public void delete(){
        underTest.delete(1L);
        verify(jdbcTemplate).update("DELETE FROM books WHERE id = ?",1L);
    }


}
