package com.laba.solvd.bank.service.impl;

import com.laba.solvd.bank.dao.interfaces.TransactionRepository;
import com.laba.solvd.bank.model.Transaction;
import com.laba.solvd.bank.service.interfaces.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setId(null);
        transactionRepository.create(transaction);
        return transaction;

    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
