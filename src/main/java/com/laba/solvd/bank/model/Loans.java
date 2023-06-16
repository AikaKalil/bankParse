package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Loans {

    private int id;
    private double loanAmount;
    private double interestRate;
    private String loanDuration;
    private List<Loan_payments> loanPayments;

    public Loans(){

    }
    public Loans(int id, double loanAmount, double interestRate, String loanDuration, List<Loan_payments> loanPayments) {
        this.id = id;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.loanPayments = loanPayments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public List<Loan_payments> getLoanPayments() {
        return loanPayments;
    }

    public void setLoanPayments(List<Loan_payments> loanPayments) {
        this.loanPayments = loanPayments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Loans loans = (Loans) o;
        return id == loans.id &&
                Double.compare(loans.loanAmount, loanAmount) == 0 &&
                Double.compare(loans.interestRate, interestRate) == 0 &&
                Objects.equals(loanDuration, loans.loanDuration) &&
                Objects.equals(loanPayments, loans.loanPayments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanAmount, interestRate, loanDuration, loanPayments);
    }
}
