package com.epam.bohdan.homework_17.repository;

import com.epam.bohdan.homework_17.model.Address;
import com.epam.bohdan.homework_17.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    Optional<List<Customer>> findCustomersById(Integer id);

    Optional<List<Customer>> findCustomersByFirstNameAndLastName(String firstName, String lastName);

    Optional<List<Customer>> findCustomersByAddressList(List<Address> addressList);

    @Query("{'accountList.cardNumber': ?0}")
    Optional<List<Customer>> findCustomersByCardNumber(Integer cardNumber);

    @Query("{'accountList.expirationDate': {$lt: ?0}}")
    Optional<List<Customer>> findCustomersWithExpiredCard(LocalDate localDate);
}
