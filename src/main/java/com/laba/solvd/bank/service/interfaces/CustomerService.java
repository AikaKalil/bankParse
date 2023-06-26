package com.laba.solvd.bank.service.interfaces;

import com.laba.solvd.bank.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
