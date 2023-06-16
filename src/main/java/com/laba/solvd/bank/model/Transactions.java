package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.Objects;

public class Transactions {
    private int id;
    private String transactionType;
    private double amount;
    private Date transactionDate;

    public Transactions(){

    }

    public Transactions(int id, String transactionType, double amount, Date transactionDate) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transactions that = (Transactions) o;
        return id == that.id &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionType, amount, transactionDate);
    }


}
