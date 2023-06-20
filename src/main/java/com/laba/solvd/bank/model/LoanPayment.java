package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.Objects;

public class LoanPayment {
    private int id;
    private double paymentAmount;
    private Date paymentDate;

    public LoanPayment(){

    }
    public LoanPayment(int id, double paymentAmount, Date paymentDate) {
        this.id = id;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoanPayment that = (LoanPayment) o;
        return id == that.id &&
                Double.compare(that.paymentAmount, paymentAmount) == 0 &&
                Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentAmount, paymentDate);
    }
}
