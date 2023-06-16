package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cards {

    private int id;
    private String cardNumber;
    private Date expirationDate;
    private int accountId;
    private Card_types cardType;

    public Cards(){

    }

    public Cards(int id, String cardNumber, Date expirationDate, int accountId, Card_types cardType) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.accountId = accountId;
        this.cardType = cardType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Card_types getCardType() {
        return cardType;
    }

    public void setCardType(Card_types cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cards card = (Cards) o;
        return id == card.id &&
                Objects.equals(cardNumber, card.cardNumber) &&
                Objects.equals(expirationDate, card.expirationDate) &&
                accountId == card.accountId &&
                Objects.equals(cardType, card.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, expirationDate, accountId, cardType);
    }
}
