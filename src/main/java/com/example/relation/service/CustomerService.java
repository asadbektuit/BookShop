package com.example.relation.service;

import com.example.relation.dto.CustomerDto;
import com.example.relation.entity.Customer;
import com.example.relation.repository.CustomerRepository;
import com.example.relation.exception.BadRequest;
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
        convertEntityToDto(customer, dto);
        return dto;
    }


    public CustomerDto create(CustomerDto dto) {
        Customer customer = new Customer();
        convertDtoToEntity(customer, dto);
        customer.setCreatedAt(LocalDateTime.now());
        customerRepository.save(customer);
        dto.setId(customer.getId());
        return dto;
    }

    public boolean update(Integer id, CustomerDto dto) {
        Customer customer = getEntity(id);
        convertDtoToEntity(customer, dto);
        customer.setUpdatedAt(LocalDateTime.now());
        customerRepository.save(customer);
        return true;
    }

    public boolean delete(Integer id) {
        Customer customer = getEntity(id);
        customer.setDeletedAt(LocalDateTime.now());
        customerRepository.save(customer);
        return true;
    }

    public void convertEntityToDto(Customer customer, CustomerDto dto) {
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        dto.setCity(customer.getCity());
        dto.setPassword(customer.getPassword());
        dto.setContact(customer.getContact());
        dto.setEmail(customer.getEmail());
    }

    public void convertDtoToEntity(Customer customer, CustomerDto dto) {
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setCity(dto.getCity());
        customer.setPassword(dto.getPassword());
        customer.setContact(dto.getContact());
        customer.setEmail(dto.getEmail());
        customer.setUpdatedAt(LocalDateTime.now());
    }


    public Customer getEntity(Integer id) {
        Optional<Customer> optional = customerRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Customer not found");
        }
        return optional.get();
    }
}
