package com.epam.bohdan.homework_17.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Account {

    Integer cardNumber;

    String nameOnAccount;

    LocalDate expirationDate;
}
