package com.laba.solvd.bank.dao.interfaces;

import com.laba.solvd.bank.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CustomerMapper {
    List<Customer> mapResultSetToCustomerList(ResultSet resultSet) throws SQLException;
}
