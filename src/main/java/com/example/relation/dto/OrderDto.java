package com.example.relation.dto;

import com.example.relation.entity.Book;
import com.example.relation.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Integer id;
    @NotBlank(message = ("Invalid quantity"))
    @Size(min = 1, max = 100)
    private Integer quantity;
    private BookDto book;
    private Integer bookId;
    private CustomerDto customer;
    private Integer userId;
    @NotBlank(message = ("Invalid price"))
    private Double totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
