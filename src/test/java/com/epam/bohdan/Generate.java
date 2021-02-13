package com.epam.bohdan;

import com.epam.bohdan.model.Account;
import com.epam.bohdan.model.Address;
import com.epam.bohdan.model.Customer;
import net.bytebuddy.utility.RandomString;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

public class Generate {

    private static final Random random = new SecureRandom();

    public static Customer generateCustomer(){
        return new Customer(random.nextInt(1000), RandomString.make(10), RandomString.make(10),
                Collections.singletonList(generateAddress()), Collections.singletonList(generateAccount()), null);
    }

    public static Account generateAccount(){
        return new Account(random.nextInt(100), "nameAccountTest", LocalDate.now());
    }

    public static Address generateAddress(){
        return new Address("HomeTest", "StreetTest", RandomString.make(10));
    }
}
