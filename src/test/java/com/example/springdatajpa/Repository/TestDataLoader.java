package com.example.springdatajpa.Repository;

import com.example.springdatajpa.Entity.Customer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private ICustomerRepository  customerRepository;

    @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         customerRepository.deleteAll();
     }
}
