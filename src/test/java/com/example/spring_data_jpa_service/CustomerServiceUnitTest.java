package com.example.spring_data_jpa_service;

import com.example.spring_data_jpa.entity.Customer;
import com.example.spring_data_jpa.repository.ICustomerRepository;
import com.example.spring_data_jpa.service.CustomerService;
import com.example.spring_data_jpa.service.ICustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CustomerServiceUnitTest {

    //Create Test Data to Inject into Mock
    private final Customer customerRegular = Customer.builder().id(1L).firstName("Kent").lastName("Beck").build();
    private final Customer customerNew = Customer.builder().id(2L).firstName("John").lastName("Smith").build();
    private List<Customer> customers;

    @BeforeEach
    public void setUp() {
        this.customers = Arrays.asList(this.customerRegular, this.customerNew);
    }
    @Mock
    private ICustomerRepository mockCustomerRepository;

    @InjectMocks
    private ICustomerService customerService = new CustomerService(this.mockCustomerRepository);

    @AfterEach
    public void tearDown() {
        this.customers = null;
    }

    @Test
    void givenCustomers_whenFetchedByID_returnsRespectiveCustomer()
    {
        //Arrange
        Mockito.when(this.mockCustomerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(this.customerNew));

        //Act
        Optional<Customer> newCustomer = this.customerService.findById((long) 2);

        //Assert
        Assertions.assertTrue(newCustomer.isPresent());
        assertEquals(this.customerNew, newCustomer.get());
    }

    @Test
    void givenCustomers_whenFindAll_returnsAllCustomers()
    {
        //Arrange
        Mockito.when(this.mockCustomerRepository.findAll()).thenReturn(this.customers);
        //Act
        List<Customer> allCustomers = this.customerService.findAll();
        //Assert
        assertEquals(this.customers, allCustomers);
    }

    @Test
    void givenCustomers_whenDeleted_notReturnRemovedCustomer()
    {
        this.customerService.delete(customerRegular);
        Mockito.verify(this.mockCustomerRepository, Mockito.times(1)).delete(customerRegular);
    }

}
