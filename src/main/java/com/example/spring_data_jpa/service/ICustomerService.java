package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Customer save(Customer customer);

    void delete(Customer customer);

}
