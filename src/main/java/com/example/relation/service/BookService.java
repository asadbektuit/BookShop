package com.example.relation.service;


import com.example.relation.dto.BookDto;
import com.example.relation.entity.Book;
import com.example.relation.repository.BookRepository;
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
        dto.setTitle(book.getTitle());;
        dto.setBookImage(book.getBookImage());
        dto.setPrice(book.getPrice());
        return dto;
    }

    private Book getEntity(Integer id) {
        Optional<Book> optional =bookRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Book don't found");
        }
        return optional.get();
    }

    public BookDto create(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setBookImage(bookDto.getBookImage());
        book.setPrice(bookDto.getPrice());
        book.setCreatedAt(bookDto.getCreatedAt());
        bookRepository.save(book);
        return bookDto;
    }

    public boolean update(Integer id, BookDto bookDto) {
        Book update = getEntity(id);
        update.setAuthor(bookDto.getAuthor());
        update.setTitle(bookDto.getTitle());
        update.setBookImage(bookDto.getBookImage());
        update.setPrice(bookDto.getPrice());
        update.setUpdatedAt(bookDto.getUpdatedAt());
        bookRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Book book = getEntity(id);
        book.setDeletedAt(LocalDateTime.now());
        bookRepository.save(book);
        return true;
    }
}
