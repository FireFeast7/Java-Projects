package dao.impl;

import dao.BookDao;
import domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (author_id, isbn, title) VALUES (?, ?, ?)",book.getAuthor_id(),book.getIsbn(),book.getTitle());
    }

    @Override
    public Optional<Book> findOne(long l) {
        List<Book> results = jdbcTemplate.query(
                "select author_id, isbn, title from books where author_id = ?",
                new BookRowMapper(),
                l);
        return results.stream().findFirst();
    }

    public List<Book> findMany() {
        List<Book> results = jdbcTemplate.query("SELECT author_id, isbn, title from books",
                new BookRowMapper());
        return results;
    }

    @Override
    public void delete(long l) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?",
                l);
    }


    public static class BookRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .author_id(rs.getLong("author_id"))
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .build();
        }
    }
}
