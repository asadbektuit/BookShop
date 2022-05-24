package com.example.relation.controller;

import com.example.relation.dto.CustomerDto;
import com.example.relation.entity.Customer;
import com.example.relation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        CustomerDto result = customerService.get(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CustomerDto dto){
        CustomerDto result = customerService.create(dto);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid CustomerDto dto) {
        boolean result = customerService.update(id, dto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Integer id){
        boolean result = customerService.delete(id);
        return ResponseEntity.ok(result);
    }

}
