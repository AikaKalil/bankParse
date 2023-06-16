package com.laba.solvd.bank.dao;

import com.laba.solvd.bank.model.Customers;

import java.util.List;

public interface CustomersRepository {
    void create(Customers customer);
    List<Customers>findAll();
    void deleteById(int id);
}
