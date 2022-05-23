package com.example.relation.repository;

import com.example.relation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findByIdAndDeletedAtIsNull(Integer id);

}
