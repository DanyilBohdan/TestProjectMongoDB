package com.epam.bohdan.homework_17.service.impl;

import com.epam.bohdan.homework_17.model.Address;
import com.epam.bohdan.homework_17.model.Customer;
import com.epam.bohdan.homework_17.repository.CustomerRepository;
import com.epam.bohdan.homework_17.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Optional<List<Customer>> findById(Integer id) {
        return customerRepository.findCustomersById(id);
    }

    @Override
    public Optional<List<Customer>> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findCustomersByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Optional<List<Customer>> findByAddressList(List<Address> addressList) {
        return customerRepository.findCustomersByAddressList(addressList);
    }

    @Override
    public Optional<List<Customer>> findByCardNumber(Integer cardNumber) {
        return customerRepository.findCustomersByCardNumber(cardNumber);
    }

    @Override
    public Optional<List<Customer>> findCustomersWithExpiredCard() {
        return customerRepository.findCustomersWithExpiredCard(LocalDate.now());
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
