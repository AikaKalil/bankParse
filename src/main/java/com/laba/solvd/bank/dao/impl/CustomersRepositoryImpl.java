package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.dao.CustomersRepository;
import com.laba.solvd.bank.model.Customers;

import java.util.List;

public class CustomersRepositoryImpl implements CustomersRepository {
    private static final ConnectionPool CONNECTION_POOL=ConnectionPool.getInstance();

    private static final String FIND_ALL_QUERY="Select "+" c.id, c.contact_id, a.id, a.account_type, a.balance, a.date_opened"+
            "FROM customers c"+"LEFT JOIN accounts a ON c.id = a.customer_id;";

    @Override
    public void create(Customers customer) {

    }
    @Override
    public List<Customers> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

}
