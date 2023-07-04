package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.laba.solvd.bank.parsers.DateAdapter;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "card")
public class Card {
    @JsonProperty("id")
    @XmlAttribute(name = "id")
    private Long id;
    @JsonProperty("cardNumber")
    @XmlElement
    private String cardNumber;
    @JsonProperty("expirationDate")
    @XmlElement(name = "expirationDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date expirationDate;
    @XmlElement(name = "cardType")
    @JsonProperty("cardType")
    private CardType cardType;

    public Card() {

    }

    public Card(String cardNumber, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
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
