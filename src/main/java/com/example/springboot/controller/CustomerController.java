package com.example.springboot.controller;

import com.example.springboot.aspect.HttpAspect;
import com.example.springboot.entity.Result;
import com.example.springboot.repository.CustomerRepository;
import com.example.springboot.entity.Customer;
import com.example.springboot.service.CustomerService;
import com.example.springboot.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    /*查询客户列表*/
    @GetMapping(value = "/getCustomerList")
    public List<Customer> customerList() {
        logger.info("---getCustomerList---");

        return customerRepository.findAll();
    }

    /*添加一个客户*/
    @PostMapping(value = "/addCustomer")
    public Result<Customer> customerAdd(@Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
             return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        customer.setName(customer.getName());
        customer.setAge(customer.getAge());
        return ResultUtil.success(customerRepository.save(customer));
    }

    /*更新客户信息*/
    @PutMapping(value = "/updateCustomer")
    public Customer customerUpdate(@Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
//        customer.setId(customer.getId());
//        customer.setAge(customer.getAge());
//        customer.setName(customer.getName());

        return customerRepository.save(customer);
    }

    /*根据id查询客户*/
    @GetMapping(value = "/getCustomer/{id}")
    public Customer customerFindOne(@PathVariable("id") Integer id) {
        logger.info("---/getCustomer/{id}---");
        return customerRepository.findOne(id);
    }

    /*删除一个客户*/
    @PostMapping(value = "/deleteCustomer")
    public void customerDelete(@RequestParam("id") Integer id) {
        customerRepository.delete(id);
    }
/*
    @GetMapping(value = "/deleteCustomer/{id}")
    private void customerDelete(@PathVariable("id") Integer id){
        customerRepository.delete(id);
    }*/

    /*根据age查询客户*/
    @PostMapping(value = "/getCustomerByAge")
    public List<Customer> customerListByAge(@RequestParam("age") Integer age){
        return customerRepository.findCustomersByAge(age);
    }

    /*根据age和name 查询客户*/
    @PostMapping(value = "/getCustomerByAgeAndName")
    public List<Customer> customerListByAgeAndName(@RequestParam("age") Integer age,
                                                    @RequestParam("name") String name){
        return customerRepository.findCustomersByAgeAndName(age,name);
    }

    /*事务测试 - 添加两个客户*/
    @GetMapping("/addCustomer/two")
    public void customerTwo(){
        customerService.insertTwo();
    }
}
