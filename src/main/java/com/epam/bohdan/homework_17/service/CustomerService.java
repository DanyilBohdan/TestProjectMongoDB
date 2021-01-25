package com.epam.bohdan.homework_17.service;

import com.epam.bohdan.homework_17.model.Address;
import com.epam.bohdan.homework_17.model.Customer;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer insertCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    List<Customer> findById(Integer id);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByAddressList(Address address);

    List<Customer> findByCardNumber(Integer id);

    List<Customer> findCustomersWithExpiredCard();

    void delete(Integer id);
}
