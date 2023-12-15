package com.project.quickstart.dao.impl;

import dao.impl.AuthorDaoImpl;
import domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    AuthorDaoImpl underTest;

    @Test
    public void createAuthor(){
        Author author = Author.builder()
                .id(1L)
                .name("Ameya")
                .age(30)
                .build();
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id,name,age) VALUES (?, ?, ?)"),
        eq(1L),eq("Ameya"),eq(30)
        );
    }

    @Test
    public void readOne(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L) );
    }
}
