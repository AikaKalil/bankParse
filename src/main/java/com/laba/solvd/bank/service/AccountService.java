package com.laba.solvd.bank.service;

import com.laba.solvd.bank.model.Account;

import java.util.List;

public interface AccountService {
    void createAccount(Account account);
    List<Account> getAllAccounts();
    void updateAccount(Account account);


}