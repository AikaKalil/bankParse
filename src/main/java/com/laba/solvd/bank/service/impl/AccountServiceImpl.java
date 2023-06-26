package com.laba.solvd.bank.service.impl;

import com.laba.solvd.bank.dao.interfaces.AccountRepository;
import com.laba.solvd.bank.dao.interfaces.TransactionRepository;
import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Transaction;
import com.laba.solvd.bank.service.interfaces.AccountService;
import com.laba.solvd.bank.service.interfaces.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private TransactionService transactionService;
    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }
    public AccountServiceImpl() {

    }


    public Account createAccount(Account account) {
        account.setId(null);
        accountRepository.create(account);
        if (account.getTransaction() != null) {
            List<Transaction> transactions = account.getTransaction().stream().
                    map(transaction -> transactionService.createTransaction(transaction))
                    .collect(Collectors.toList());
            for(Transaction transaction : transactions){
            transactionRepository.update(transaction, account);
        }
    }
        return account;
    }

    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }


}
