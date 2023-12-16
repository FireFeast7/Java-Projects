package dao.impl;

import dao.AuthorDao;
import domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id,name,age) VALUES (?, ?, ?)",
                author.getId(),author.getName(),author.getAge()
        );

    }

    @Override
    public Optional<Author> findOne(long l) {
             List<Author> results =  jdbcTemplate.query(
                     "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"
                     ,new AuthorRowMapper(),
                     l);
             return results.stream().findFirst();

    }

    public List<Author> findMany(){
        List<Author> results = jdbcTemplate.query("SELECT id, name, age FROM authors" , new AuthorRowMapper());
        return results;
    }

    public void update(Author author, long id) {
        jdbcTemplate.update(
                "UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                author.getId(),author.getName(),author.getAge(),id);
    }

    public void delete(long l) {
        jdbcTemplate.update("DELETE FROM authors WHERE id = ?"
                ,l
        );
    }

    public static class AuthorRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
