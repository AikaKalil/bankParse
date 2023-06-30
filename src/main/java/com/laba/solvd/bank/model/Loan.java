package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Loan {
    @XmlAttribute
    private Long id;
    @XmlElement
    private double loanAmount;
    @XmlElement
    private double interestRate;
    @XmlElement
    private String loanDuration;

    public Loan() {

    }

    public Loan(Long id, double loanAmount, double interestRate, String loanDuration) {
        this.id = id;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                Objects.equals(loanDuration, loan.loanDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanAmount, interestRate, loanDuration);
    }
}
