package com.example.relation.service;

import com.example.relation.dto.CustomerDto;
import com.example.relation.entity.Customer;
import com.example.relation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto get(Integer id) {
        Customer customer = getEntity(id);
        CustomerDto dto = new CustomerDto();
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        dto.setCity(customer.getCity());
        dto.setPassword(customer.getPassword());
        dto.setContact(customer.getContact());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    private Customer getEntity(Integer id) {
        Optional<Customer> optional = customerRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Customer not found");
        }
        return optional.get();
    }

    public CustomerDto create(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setCity(dto.getCity());
        customer.setPassword(dto.getPassword());
        customer.setContact(dto.getContact());
        customer.setEmail(dto.getEmail());
        customer.setCreatedAt(LocalDateTime.now());
        customerRepository.save(customer);
        return dto;
    }

    public Boolean update(Integer id, Customer customer) {
        Customer update = getEntity(id);
        update.setName(customer.getName());
        update.setSurname(customer.getSurname());
        update.setCity(customer.getCity());
        update.setPassword(customer.getPassword());
        update.setContact(customer.getContact());
        update.setEmail(customer.getEmail());
        update.setUpdatedAt(customer.getUpdatedAt());
        customerRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Customer customer = getEntity(id);
        customer.setDeletedAt(LocalDateTime.now());
        customerRepository.save(customer);
        return true;
    }
}
