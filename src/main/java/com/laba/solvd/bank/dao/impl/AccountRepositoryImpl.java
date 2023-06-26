package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.ConnectionPool;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Customer;
import com.laba.solvd.bank.model.Transaction;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    Logger logger = Logger.getLogger(AccountRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Account account) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO accounts (account_type, balance) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, account.getAccountType());
            statement.setDouble(2, account.getBalance());
            statement.executeUpdate();

            ResultSet resultSet=statement.getGeneratedKeys();
            while(resultSet.next()){
                account.setId((resultSet.getLong("id")));
            }
        } catch (SQLException e) {
            logger.info("Unable to execute statement",e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Account> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Account> accounts = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT a.id, a.account_type, a.balance, t.id, t.transaction_type, t.amount, t.transaction_date\n" +
                     "FROM accounts a\n" +
                     "INNER JOIN transactions t ON a.id = t.account_id;")) {
            accounts = mapAccounts(resultSet);
        } catch (SQLException e) {
            logger.info("Unable to find accounts!",e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return accounts;
    }

    @Override
    public void update(Account account, Customer customer) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("UPDATE accounts SET account_type = ?, balance = ? WHERE id = ?")) {
            statement.setString(1, account.getAccountType());
            statement.setDouble(2, account.getBalance());
            statement.setLong(3, account.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.info("Unable to update!",e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private static Account findById(Long id, List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst().orElseGet(() -> {
                    Account newAccount = new Account();
                    newAccount.setId(id);
                    accounts.add(newAccount);
                    return newAccount;
                });
    }

    private static List<Account> mapAccounts(ResultSet resultSet) throws SQLException{
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Long id=resultSet.getLong("id");
            Account account = findById(id,accounts);
            account.setId(resultSet.getLong("id"));
            account.setAccountType(resultSet.getString("account_type"));
            account.setBalance(resultSet.getDouble("balance"));
            List<Transaction> transactions = TransactionRepositoryImpl.mapRow(resultSet, account.getTransaction());
            account.setTransaction(transactions);
        }
        return accounts;
    }

    public static List<Account> mapRow (ResultSet resultSet, List<Account> accounts) throws SQLException{
        long id=resultSet.getLong("id");

        if(id !=0){
            if(accounts==null){
                accounts=new ArrayList<>();
            }

            Account account=findById(id,accounts);
            account.setAccountType(resultSet.getString("account_type"));
            account.setBalance(resultSet.getDouble("balance"));
            account.setTransaction(TransactionRepositoryImpl.mapRow(resultSet,account.getTransaction()));
        }
        return accounts;
    }
}
