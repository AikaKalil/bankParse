package com.laba.solvd.bank.service.impl;

import com.laba.solvd.bank.dao.interfaces.CustomerRepository;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}

