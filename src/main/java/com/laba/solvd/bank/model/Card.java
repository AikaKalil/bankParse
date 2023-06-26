package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.Objects;

public class Card {

    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private CardType cardType;

    public Card() {

    }

    public Card(Long id, String cardNumber, Date expirationDate, CardType cardType) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
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
        Card card = (Card) o;
        return id == card.id &&
                Objects.equals(cardNumber, card.cardNumber) &&
                Objects.equals(expirationDate, card.expirationDate) &&
                Objects.equals(cardType, card.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, expirationDate, cardType);
    }
}
