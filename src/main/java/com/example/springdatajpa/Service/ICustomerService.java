package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<Customer> findById(Long Id);

    List<Customer> findAll();

    Customer save(Customer customer);

    void delete(Customer customer);

    void deleteAll();
}
