package com.project.quickstart;

import com.project.quickstart.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> {
}
