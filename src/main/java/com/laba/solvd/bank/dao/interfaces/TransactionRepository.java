package com.laba.solvd.bank.dao.interfaces;

import com.laba.solvd.bank.model.Account;
import com.laba.solvd.bank.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void create(Transaction transaction);
    List<Transaction> findAll();
    void update(Transaction transaction);
}
