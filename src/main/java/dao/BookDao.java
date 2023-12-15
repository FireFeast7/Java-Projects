package dao;

import domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);
    Optional<Book> findOne(long l);
}
