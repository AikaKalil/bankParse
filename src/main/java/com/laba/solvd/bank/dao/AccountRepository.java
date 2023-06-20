package com.laba.solvd.bank.dao;

import com.laba.solvd.bank.model.Account;

import java.util.List;

public interface AccountRepository {
    void create(Account account);
    List<Account> findAll();
    void update(Account account);

}
