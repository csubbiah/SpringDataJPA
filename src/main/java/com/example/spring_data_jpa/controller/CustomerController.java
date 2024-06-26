package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.exception.DataNotFoundException;
import com.example.spring_data_jpa.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.spring_data_jpa.entity.Customer;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/Customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
     public CustomerController(CustomerService customerService) {
         this.customerService = customerService;
     }

     @GetMapping
     public List<Customer> getAllCustomers() {
        return customerService.findAll();
     }

     @PostMapping
     public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
     }

     @GetMapping("/{id}")
     public Customer getCustomer(@PathVariable long id) {
        return customerService.findById(id).orElse(null);
     }

     @DeleteMapping("/{id}")
     public void deleteCustomer(@PathVariable long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(customerOptional.isPresent()) {
            customerService.delete(customerOptional.get());
        }
        else
        {
            log.info("Customer with id {} not found", id);
            throw new DataNotFoundException("Customer with id " + id + " not found");
        }
     }
}
