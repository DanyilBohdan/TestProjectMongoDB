package com.epam.bohdan.homework_17.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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
