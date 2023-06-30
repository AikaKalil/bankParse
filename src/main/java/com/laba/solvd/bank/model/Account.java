package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @XmlAttribute
    private Long id;
    @XmlElement
    @JsonProperty("accountType")
    private String accountType;
    @XmlElement
    private double balance;
    @JsonProperty("transaction")
    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    private List<Transaction> transaction;
    @JsonProperty("card")
    @XmlElementWrapper(name = "cards")
    @XmlElement(name = "card")
    private List<Card> card;
    @JsonProperty("loan")
    @XmlElementWrapper(name = "loans")
    @XmlElement(name = "loan")
    private List<Loan> loan;

    public Account() {

    }

    public Account( String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public List<Loan> getLoan() {
        return loan;
    }

    public void setLoan(List<Loan> loan) {
        this.loan = loan;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return id == account.id &&
                Double.compare(account.balance, balance) == 0 &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(transaction, account.transaction) &&
                Objects.equals(card, account.card) &&
                Objects.equals(loan, account.loan);
    }

    @Override
    public int hashCode() {
        return Objects.hash("Department{"+"id="+id,"\nAccount type="+accountType,"\nBalance"+ balance,"\nTransaction="+transaction,"\nCard"+card,"\nLoan="+loan);
    }

}
