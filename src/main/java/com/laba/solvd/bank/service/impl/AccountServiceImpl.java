package com.laba.solvd.bank.service.impl;

import com.laba.solvd.bank.dao.AccountRepository;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public void createAccount(Account account) {
        accountRepository.create(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void updateAccount(Account account) {
        accountRepository.update(account);
    }
}
