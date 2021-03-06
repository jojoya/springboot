package com.example.springboot.service;

import com.example.springboot.enums.CustomerAgeResultEnum;
import com.example.springboot.exception.CustomerException;
import com.example.springboot.repository.CustomerRepository;
import com.example.springboot.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void insertTwo(){
        Customer customer1 = new Customer();
        customer1.setName("毛爷爷");
        customer1.setAge(100);
        customerRepository.save(customer1);

        System.out.println("1/2");

        Customer customer2 = new Customer();
        customer2.setAge(90);
        customer2.setName("邓爷爷");
        customerRepository.save(customer2);

        System.out.println("2/2");

    }

    public void getAge(Integer id) throws Exception{
        Customer customer = customerRepository.findOne(id);
        Integer age = customer.getAge();
        if(age<10){
            throw new CustomerException(CustomerAgeResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10 && age <16){
            throw new CustomerException(CustomerAgeResultEnum.MIDDLE_SCHOOL);
        }else{
            throw new CustomerException(CustomerAgeResultEnum.SOCIAL_MAN);
        }
    }

    public Customer getOne(int id){
        return customerRepository.findOne(id);
    }
}
