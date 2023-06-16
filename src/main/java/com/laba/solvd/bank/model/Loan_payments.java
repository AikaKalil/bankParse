package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.Objects;

public class Loan_payments {
    private int id;
    private double paymentAmount;
    private Date paymentDate;
    private Loans loans;

    public Loan_payments(){

    }
    public Loan_payments(int id, double paymentAmount, Date paymentDate, Loans loans) {
        this.id = id;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.loans = loans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Loans getLoans() {
        return loans;
    }

    public void setLoans(Loans loans) {
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
        Loan_payments that = (Loan_payments) o;
        return id == that.id &&
                Double.compare(that.paymentAmount, paymentAmount) == 0 &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(loans, that.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentAmount, paymentDate, loans);
    }
}
