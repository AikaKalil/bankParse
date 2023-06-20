package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.interfaces.AccountMapper;
import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private final ConnectionPool connectionPool;
    private final Connection connection;
    private final AccountMapper accountMapper;


    public AccountRepositoryImpl(ConnectionPool connectionPool, AccountMapper accountMapper) {
        this.connectionPool = connectionPool;
        this.connection = connectionPool.getConnection();
        this.accountMapper = accountMapper;
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
             accounts = accountMapper.mapResultSetToAccountList(resultSet);
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
