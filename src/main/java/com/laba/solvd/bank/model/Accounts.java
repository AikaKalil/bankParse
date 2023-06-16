package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Accounts {

    private int id;
    private String accountType;
    private double balance;
    private List<Transactions> transactions;
    private List<Cards> cards;
    private List<Loans> loans;

    public Accounts(){

    }
    public Accounts(int id, String accountType, double balance, List<Transactions> transactions, List<Cards> cards, List<Loans> loans) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = transactions;
        this.cards = cards;
        this.loans = loans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public List<Loans> getLoans() {
        return loans;
    }

    public void setLoans(List<Loans> loans) {
        this.loans = loans;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                Double.compare(accounts.balance, balance) == 0 &&
                Objects.equals(accountType, accounts.accountType) &&
                Objects.equals(transactions, accounts.transactions) &&
                Objects.equals(cards, accounts.cards) &&
                Objects.equals(loans, accounts.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountType, balance, transactions, cards, loans);
    }

    }
