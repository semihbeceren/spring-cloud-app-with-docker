package com.semihbeceren.Repository;

import com.semihbeceren.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Semih Beceren on 17.11.2016.
 */
@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {
}
