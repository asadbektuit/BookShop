package com.example.relation.service;


import com.example.relation.dto.BookDto;
import com.example.relation.entity.Book;
import com.example.relation.exception.BadRequest;
import com.example.relation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto get(Integer id) {
        Book book = getEntity(id);
        BookDto dto = new BookDto();
        convertEntityToDto(book, dto);
        return dto;
    }

    public BookDto create(BookDto bookDto) {
        Book book = new Book();
        book.setCreatedAt(LocalDateTime.now());
        convertDtoToEntity(book,bookDto);
        bookRepository.save(book);
        bookDto.setId(book.getId());
        return bookDto;
    }

    public boolean update(Integer id, BookDto bookDto) {
        Book update = getEntity(id);
        convertDtoToEntity(update,bookDto);
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

    public void convertDtoToEntity(Book update,BookDto bookDto) {
        update.setAuthor(bookDto.getAuthor());
        update.setTitle(bookDto.getTitle());
        update.setPrice(bookDto.getPrice());
    }

    public void convertEntityToDto(Book book, BookDto dto) {
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setPrice(book.getPrice());
    }

    public Book getEntity(Integer id) {
        Optional<Book> optional = bookRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Book not found");
        }
        return optional.get();
    }
}
