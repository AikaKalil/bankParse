package com.laba.solvd.bank.service.interfaces;

import com.laba.solvd.bank.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAllAccounts();


}