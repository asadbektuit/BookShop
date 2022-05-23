package com.example.relation.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "books")
public class Book {


    private Integer id;

    private String author;

    private String title;

    private Double price;

    private String book_image;

    @Column(name = "published_date")
    private Date publishedDate;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
