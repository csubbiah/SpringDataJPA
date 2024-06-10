package com.example.springdatajpa.Repository;

import com.example.springdatajpa.Entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Autowired
    ICustomerRepository customerRepository;

    @Test
    public void givenCustomerDatabase_whenfindByID_thenReturnCustomer() {
        //Arrange
        Customer expectedCustomer = new Customer();
        expectedCustomer.setFirstName("FName");
        expectedCustomer.setLastName("LName");
        customerRepository.save(expectedCustomer);
        List<Customer> customerList = customerRepository.findAll();

        //Act
        Long id = customerList.get(0).getId();
        Optional<Customer> actualCustomer = customerRepository.findById(id);

        //Assert
        assertEquals(expectedCustomer.getId() , actualCustomer.get().getId());
        assertEquals(expectedCustomer.getFirstName(), actualCustomer.get().getFirstName());
        assertEquals(expectedCustomer.getLastName(), actualCustomer.get().getLastName());
    }

    @Test
    public void givenCustomerDatabase_whenfindAll_thenReturnCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        assertEquals(customerList.size(), 1);
    }

    @Test
    public void givenCustomerDatabase_whendeleted_thenDoNotReturnCustomer() {
        List<Customer> customerList = customerRepository.findAll();

        //Act
        Long id = customerList.get(0).getId();
        customerRepository.deleteById(id);
        Optional<Customer> actualCustomer = customerRepository.findById(id);
        actualCustomer.ifPresent(Assertions::assertNull);
    }
}
