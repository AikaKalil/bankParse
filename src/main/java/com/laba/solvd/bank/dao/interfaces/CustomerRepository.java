package com.laba.solvd.bank.dao.interfaces;

import com.laba.solvd.bank.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void create(Customer customer);
    List<Customer>findAll();
}
