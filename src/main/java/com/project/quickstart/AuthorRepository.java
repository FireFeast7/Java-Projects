package com.project.quickstart;

import com.project.quickstart.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Iterable<Author> ageLessThan(int i);

    @Query("Select a from Author a where  a.age > ?1")
    Iterable<Author> findauthorwithAgeGreaterthan(int i);
}
