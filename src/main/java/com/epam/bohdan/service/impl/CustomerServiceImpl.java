package com.epam.bohdan.service.impl;

import com.epam.bohdan.model.Address;
import com.epam.bohdan.model.Customer;
import com.epam.bohdan.repository.CustomerRepository;
import com.epam.bohdan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findById(Integer id) {
        return customerRepository.findCustomersById(id).orElseThrow();
    }

    @Override
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findCustomersByFirstNameAndLastName(firstName, lastName).orElseThrow();
    }

    @Override
    public List<Customer> findByAddressList(Address address) {
        return customerRepository.findCustomersByAddressList(Collections.singletonList(address)).orElseThrow();
    }

    @Override
    public List<Customer> findByCardNumber(Integer cardNumber) {
        return customerRepository.findCustomersByCardNumber(cardNumber).orElseThrow();
    }

    @Override
    public List<Customer> findCustomersWithExpiredCard() {
        return customerRepository.findCustomersWithExpiredCard(LocalDate.now()).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
