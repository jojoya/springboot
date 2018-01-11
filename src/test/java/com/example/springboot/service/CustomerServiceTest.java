package com.example.springboot.service;

import com.example.springboot.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void insertTwo() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

    @Test
    public void getOne() throws Exception {
        Customer customer = customerService.getOne(1);
        Assert.assertEquals("一十",customer.getName());
        Assert.assertEquals(8,customer.getAge());
    }

}