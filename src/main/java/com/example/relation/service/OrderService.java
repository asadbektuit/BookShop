package com.example.relation.service;

import com.example.relation.dto.OrderDto;
import com.example.relation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;


    public OrderDto get(Integer id) {
        return null;
    }

    public boolean create(OrderDto dto) {
        return true;
    }
}
