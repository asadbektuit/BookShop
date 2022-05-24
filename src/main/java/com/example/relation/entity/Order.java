package com.example.relation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter

@Entity
@Table(name = ("orders"))
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = ("book_id"), updatable = false, insertable = false)
    private Book book;

    @Column(name = ("book_id"))
    private Integer bookId;

    @ManyToOne
    @JoinColumn(name = ("user_id"), updatable = false, insertable = false)
    private Customer customer;

    @Column(name = ("user_id"))
    private Integer userId;

    @Column(name = ("total_price"))
    private Double totalPrice;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
