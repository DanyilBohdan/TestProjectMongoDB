package com.epam.bohdan;

import com.epam.bohdan.model.Customer;
import com.epam.bohdan.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIT {

    @Autowired
    private CustomerService customerService;

    @Test
    public void createCustomerTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);

        Assert.assertEquals(customer.getId(), createdCustomer.getId());
        Assert.assertEquals(customer.getFirstName(), createdCustomer.getFirstName());
        Assert.assertEquals(customer.getLastName(), createdCustomer.getLastName());
        Assert.assertEquals(customer.getAccountList(), createdCustomer.getAccountList());
        Assert.assertEquals(customer.getAddressList(), createdCustomer.getAddressList());
        Assert.assertEquals(customer.getObjectId(), createdCustomer.getObjectId());
    }

    @Test
    public void updateCustomerTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);
        createdCustomer.setFirstName("UpdateFirstName");
        createdCustomer.setLastName("UpdateLastName");
        Customer updatedCustomer = customerService.updateCustomer(createdCustomer);

        Assert.assertEquals(createdCustomer.getFirstName(), updatedCustomer.getFirstName());
        Assert.assertEquals(createdCustomer.getLastName(), updatedCustomer.getLastName());
    }

    @Test
    public void findCustomerByIdTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);

        Customer foundCustomer = customerService.findById(createdCustomer.getId()).get(0);

        Assert.assertEquals(customer.getId(), foundCustomer.getId());
        Assert.assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
        Assert.assertEquals(customer.getLastName(), foundCustomer.getLastName());
        Assert.assertEquals(customer.getAccountList(), foundCustomer.getAccountList());
        Assert.assertEquals(customer.getAddressList(), foundCustomer.getAddressList());
        Assert.assertEquals(customer.getObjectId(), foundCustomer.getObjectId());
    }

    @Test
    public void findByFirstNameAndLastNameTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);

        Customer foundCustomer = customerService.findByFirstNameAndLastName(createdCustomer.getFirstName(), createdCustomer.getLastName()).get(0);

        Assert.assertEquals(customer.getId(), foundCustomer.getId());
        Assert.assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
        Assert.assertEquals(customer.getLastName(), foundCustomer.getLastName());
        Assert.assertEquals(customer.getAccountList(), foundCustomer.getAccountList());
        Assert.assertEquals(customer.getAddressList(), foundCustomer.getAddressList());
        Assert.assertEquals(customer.getObjectId(), foundCustomer.getObjectId());
    }

    @Test
    public void findCustomersByAddressListTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);

        Customer foundCustomer = customerService.findByAddressList(createdCustomer.getAddressList().get(0)).get(0);

        Assert.assertEquals(customer.getId(), foundCustomer.getId());
        Assert.assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
        Assert.assertEquals(customer.getLastName(), foundCustomer.getLastName());
        Assert.assertEquals(customer.getAccountList(), foundCustomer.getAccountList());
        Assert.assertEquals(customer.getAddressList(), foundCustomer.getAddressList());
        Assert.assertEquals(customer.getObjectId(), foundCustomer.getObjectId());
    }

    @Test
    public void findCustomersByCardNumberTest(){
        Customer customer = Generate.generateCustomer();

        Customer createdCustomer = customerService.insertCustomer(customer);

        Customer foundCustomer = customerService.findByCardNumber(createdCustomer.getAccountList().get(0).getCardNumber()).get(0);

        Assert.assertEquals(customer.getId(), foundCustomer.getId());
        Assert.assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
        Assert.assertEquals(customer.getLastName(), foundCustomer.getLastName());
        Assert.assertEquals(customer.getAccountList(), foundCustomer.getAccountList());
        Assert.assertEquals(customer.getAddressList(), foundCustomer.getAddressList());
        Assert.assertEquals(customer.getObjectId(), foundCustomer.getObjectId());
    }

    @Test
    public void findCustomersWithExpiredCardTest(){
        Customer customer1 = Generate.generateCustomer();
        Customer customer2 = Generate.generateCustomer();

        customer1.getAccountList().get(0).setExpirationDate(LocalDate.of(2019, 5, 1));
        Customer createdCustomer1 = customerService.insertCustomer(customer1);
        Customer createdCustomer2 = customerService.insertCustomer(customer2);

        Customer foundCustomer = customerService.findCustomersWithExpiredCard().get(0);

        Assert.assertEquals(createdCustomer1.getId(), foundCustomer.getId());
        Assert.assertEquals(createdCustomer1.getFirstName(), foundCustomer.getFirstName());
        Assert.assertEquals(createdCustomer1.getLastName(), foundCustomer.getLastName());
        Assert.assertEquals(createdCustomer1.getAccountList(), foundCustomer.getAccountList());
        Assert.assertEquals(createdCustomer1.getAddressList(), foundCustomer.getAddressList());
        Assert.assertEquals(createdCustomer1.getObjectId(), foundCustomer.getObjectId());
    }
}
