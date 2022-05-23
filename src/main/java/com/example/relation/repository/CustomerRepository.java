package com.example.relation.repository;

import com.example.relation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByIdAndDeletedAtIsNull(Integer id);
}
