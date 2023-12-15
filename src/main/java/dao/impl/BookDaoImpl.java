package dao.impl;

import dao.BookDao;
import domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (author_id, isbn, title) VALUES (?, ?, ?)",book.getAuthor_id(),book.getIsbn(),book.getTitle());
    }
}
