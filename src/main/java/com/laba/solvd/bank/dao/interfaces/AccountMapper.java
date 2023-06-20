package com.laba.solvd.bank.dao.interfaces;

import com.laba.solvd.bank.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AccountMapper {
    Account mapResultSetToAccount(ResultSet resultSet) throws SQLException;

    List<Account> mapResultSetToAccountList(ResultSet resultSet) throws SQLException;
}
