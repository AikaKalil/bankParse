package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.AccountRepository;
import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private final ConnectionPool connectionPool;
    private final Connection connection;

    public AccountRepositoryImpl(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.connection = connectionPool.getConnection();
    }

    @Override
    public void create(Account account) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (id, account_type, balance) VALUES (?, ?, ?)")) {
            statement.setInt(1, account.getId());
            statement.setString(2, account.getAccountType());
            statement.setDouble(3, account.getBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String accountType = resultSet.getString("account_type");
                double balance = resultSet.getDouble("balance");
                Account account = new Account(id, accountType, balance, null, null, null);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return accounts;
    }

    @Override
    public void update(Account account) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET account_type = ?, balance = ? WHERE id = ?")) {
            statement.setString(1, account.getAccountType());
            statement.setDouble(2, account.getBalance());
            statement.setInt(3, account.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
