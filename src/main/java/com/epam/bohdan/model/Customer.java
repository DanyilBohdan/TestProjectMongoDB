package com.epam.bohdan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
@Data
@AllArgsConstructor
public class Customer {

    @Id
    Integer id;

    String firstName;

    String lastName;

    List<Address> addressList;

    List<Account> accountList;

    UUID objectId;
}
