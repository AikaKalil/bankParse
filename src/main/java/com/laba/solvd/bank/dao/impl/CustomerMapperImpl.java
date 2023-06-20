package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.interfaces.CustomerMapper;
import com.laba.solvd.bank.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public List<Customer> mapResultSetToCustomerList(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Customer customer = new Customer(id, firstName, lastName, null, null);
            customers.add(customer);
        }
        return customers;
    }
}
