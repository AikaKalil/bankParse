package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "account")
public class Account {
    @XmlAttribute(name="id")
    private Long id;
    @XmlElement
    @JsonProperty("accountType")
    private String accountType;
    @XmlElement
    private double balance;
    @JsonProperty("transactions")
    @XmlElementWrapper(name = "transactions")
    @XmlElement(name = "transaction")
    private List<Transaction> transactions;
    @JsonProperty("cards")
    @XmlElementWrapper(name = "cards")
    @XmlElement(name = "card")
    private List<Card> cards;
    @JsonProperty("loans")
    @XmlElementWrapper(name = "loans")
    @XmlElement(name = "loan")
    private List<Loan> loans;

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
        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Card> getCard() {
        return cards;
    }

    public void setCard(List<Card> cards) {
        this.cards = cards;
    }

    public List<Loan> getLoan() {
        return loans;
    }

    public void setLoan(List<Loan> loans) {
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
        Account account = (Account) o;
        return id == account.id &&
                Double.compare(account.balance, balance) == 0 &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(transactions, account.transactions) &&
                Objects.equals(cards, account.cards) &&
                Objects.equals(loans, account.loans);
    }

    @Override
    public int hashCode() {
        return Objects.hash("Department{"+"id="+id,"\nAccount type="+accountType,"\nBalance"+ balance,"\nTransaction="+transactions,"\nCard"+cards,"\nLoan="+loans);
    }

}
