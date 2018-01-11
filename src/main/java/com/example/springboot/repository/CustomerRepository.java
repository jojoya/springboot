package com.example.springboot.repository;

import com.example.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public List<Customer> findCustomersByAge(Integer age);

    public List<Customer> findCustomersByAgeAndName(Integer age,String name);

}
