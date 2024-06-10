package com.example.springdatajpa.Service;

import com.example.springdatajpa.Entity.Customer;
import com.example.springdatajpa.Repository.ICustomerRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Long Id) {
        return customerRepository.findById(Id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
