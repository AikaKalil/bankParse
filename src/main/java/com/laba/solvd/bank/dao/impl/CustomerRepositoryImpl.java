package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.dao.CustomerRepository;
import com.laba.solvd.bank.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final ConnectionPool connectionPool;

    public CustomerRepositoryImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    @Override
    public void create(Customer customer) {
        Connection connection = connectionPool.getConnection();
        try {
            String sql = "INSERT INTO customers (id, firstName, lastName) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create customer", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Customer> findAll() {
        Connection connection = connectionPool.getConnection();
        try {
            String sql = "SELECT * FROM customers";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");


                Customer customer = new Customer(id, firstName, lastName, null, null);
                customers.add(customer);
            }

            return customers;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve customers", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(int id) {
        Connection connection = connectionPool.getConnection();
        try {

            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete customer", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
    }
