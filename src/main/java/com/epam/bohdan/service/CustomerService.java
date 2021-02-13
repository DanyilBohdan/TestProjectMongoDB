package com.epam.bohdan.service;

import com.epam.bohdan.model.Address;
import com.epam.bohdan.model.Customer;

import java.util.List;

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
