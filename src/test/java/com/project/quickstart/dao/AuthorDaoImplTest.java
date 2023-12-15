package com.project.quickstart.dao;

import dao.impl.AuthorDaoImpl;
import domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
