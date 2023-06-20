package com.laba.solvd.bank.service;

import com.laba.solvd.bank.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    void deleteCustomerById(int id);
}
