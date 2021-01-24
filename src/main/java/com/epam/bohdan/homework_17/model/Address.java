package com.epam.bohdan.homework_17.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    String line1;

    String line2;

    String countryCode;
}
