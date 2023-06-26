package com.laba.solvd.bank.dao.interfaces;

import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Customer;

import java.util.List;

public interface AccountRepository {
    void create(Account account);
    List<Account> findAll();
    void update(Account account, Customer customer);

}
