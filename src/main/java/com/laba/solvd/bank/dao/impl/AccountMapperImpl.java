package com.laba.solvd.bank.dao.impl;

import com.laba.solvd.bank.dao.interfaces.AccountMapper;
import com.laba.solvd.bank.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountMapperImpl implements AccountMapper {
    @Override
    public Account mapResultSetToAccount(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String accountType = resultSet.getString("account_type");
        double balance = resultSet.getDouble("balance");
        return new Account(id, accountType, balance, null, null, null);
    }

    @Override
    public List<Account> mapResultSetToAccountList(ResultSet resultSet) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String accountType = resultSet.getString("account_type");
            double balance = resultSet.getDouble("balance");
            Account account = new Account(id, accountType, balance, null, null, null);
            accounts.add(account);
        }
        return accounts;
    }
}
