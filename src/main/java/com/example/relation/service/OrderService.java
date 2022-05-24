package com.example.relation.service;

import com.example.relation.dto.OrderDto;
import com.example.relation.entity.Order;
import com.example.relation.exception.BadRequest;
import com.example.relation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    public Order getEntity(Integer id){
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Order not found");
        }
        return optional.get();
    }
    public OrderDto get(Integer id) {
        Order order = getEntity(id);
        OrderDto orderDto = new OrderDto();
        orderDto.setBook(bookService.get(orderDto.getBookId()));
        orderDto.setCustomer(customerService.get(orderDto.getUserId()));
        orderDto.setQuantity(order.getQuantity());
        orderDto.setTotalPrice(order.getTotalPrice());
        return orderDto;
    }

    public OrderDto create(OrderDto dto) {
        Order order = new Order();
        //TODO: check book
        bookService.getEntity(dto.getBookId());
        order.setBookId(dto.getBookId());
        //TODO: check customer
        customerService.getEntity(dto.getUserId());
        order.setUserId(dto.getUserId());

        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
        return dto;
    }

    public boolean update(Integer id, OrderDto dto) {
        Order order = getEntity(id);
        //TODO: check book
        bookService.getEntity(dto.getBookId());
        order.setBookId(dto.getBookId());
        //TODO: check customer
        customerService.getEntity(dto.getUserId());
        order.setUserId(dto.getUserId());

        order.setUpdatedAt(LocalDateTime.now());
        order.setQuantity(dto.getQuantity());
        order.setTotalPrice(dto.getTotalPrice());
        orderRepository.save(order);
        return true;
    }

    public boolean delete(Integer id) {
        Order order = getEntity(id);
        order.setDeletedAt(LocalDateTime.now());
        orderRepository.save(order);
        return true;
    }
}
