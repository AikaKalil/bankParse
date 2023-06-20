package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Loan {

    private int id;
    private double loanAmount;
    private double interestRate;
    private String loanDuration;
    private List<LoanPayment> loanPayments;

    public Loan(){

    }
    public Loan(int id, double loanAmount, double interestRate, String loanDuration, List<LoanPayment> loanPayments) {
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

    public List<LoanPayment> getLoanPayments() {
        return loanPayments;
    }

    public void setLoanPayments(List<LoanPayment> loanPayments) {
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
        Loan loan = (Loan) o;
        return id == loan.id &&
                Double.compare(loan.loanAmount, loanAmount) == 0 &&
                Double.compare(loan.interestRate, interestRate) == 0 &&
                Objects.equals(loanDuration, loan.loanDuration) &&
                Objects.equals(loanPayments, loan.loanPayments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanAmount, interestRate, loanDuration, loanPayments);
    }
}
