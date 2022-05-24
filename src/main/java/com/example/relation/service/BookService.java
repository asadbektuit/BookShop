package com.example.relation.service;


import com.example.relation.dto.BookDto;
import com.example.relation.entity.Book;
import com.example.relation.repository.BookRepository;
import com.example.relation.util.BadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto get(Integer id) {
        Book book = getEntity(id);
        BookDto dto = new BookDto();
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setPrice(book.getPrice());
        return dto;
    }

    public BookDto create(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setCreatedAt(LocalDateTime.now());
        bookRepository.save(book);
        return bookDto;
    }

    public boolean update(Integer id, BookDto bookDto) {
        Book update = getEntity(id);
        update.setAuthor(bookDto.getAuthor());
        update.setTitle(bookDto.getTitle());
        update.setPrice(bookDto.getPrice());
        update.setUpdatedAt(LocalDateTime.now());
        bookRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Book book = getEntity(id);
        book.setDeletedAt(LocalDateTime.now());
        bookRepository.save(book);
        return true;
    }

    public Book getEntity(Integer id) {
        Optional<Book> optional =bookRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Book don't found");
        }
        return optional.get();
    }
}
