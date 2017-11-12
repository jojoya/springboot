package com.example.springboot.controller;

import com.example.springboot.repository.CustomerRepository;
import com.example.springboot.entity.Customer;
import com.example.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    /*查询客户列表*/
    @GetMapping(value = "/getCustomerList")
    private List<Customer> customerList() {
        return customerRepository.findAll();
    }

    /*添加一个客户*/
    @PostMapping(value = "/addCustomer")
    private Customer customerAdd(@RequestParam("name") String name,
                                 @RequestParam("age") Integer age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);

        return customerRepository.save(customer);
    }

    /*更新客户信息*/
    @PutMapping(value = "/updateCustomer")
    private Customer customerUpdate(@RequestParam("id") Integer id,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Integer age) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setAge(age);
        customer.setName(name);

        return customerRepository.save(customer);
    }

    /*根据id查询客户*/
    @GetMapping(value = "/getCustomer/{id}")
    private Customer customerFindOne(@PathVariable("id") Integer id) {
        return customerRepository.findOne(id);
    }

    /*删除一个客户*/
    @PostMapping(value = "/deleteCustomer")
    private void customerDelete(@RequestParam("id") Integer id) {
        customerRepository.delete(id);
    }
/*
    @GetMapping(value = "/deleteCustomer/{id}")
    private void customerDelete(@PathVariable("id") Integer id){
        customerRepository.delete(id);
    }*/

    /*根据age查询客户*/
    @PostMapping(value = "/getCustomerByAge")
    private List<Customer> customerListByAge(@RequestParam("age") Integer age){
        return customerRepository.findCustomersByAge(age);
    }

    /*根据age和name 查询客户*/
    @PostMapping(value = "/getCustomerByAgeAndName")
    private List<Customer> customerListByAgeAndName(@RequestParam("age") Integer age,
                                                    @RequestParam("name") String name){
        return customerRepository.findCustomersByAgeAndName(age,name);
    }

    /*事务测试 - 添加两个客户*/
    @GetMapping("/addCustomer/two")
    public void customerTwo(){
        customerService.insertTwo();
    }
}
