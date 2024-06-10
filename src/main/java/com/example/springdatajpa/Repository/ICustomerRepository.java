package com.example.springdatajpa.Repository;

import com.example.springdatajpa.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
