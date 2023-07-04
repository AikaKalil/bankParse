package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;
import java.util.Objects;
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cardType")
public class CardType {
    @XmlAttribute(name="id")
    @JsonProperty("id")
    private Long id;
    @JsonProperty("credit")
    @XmlElement
    private String credit;
    @XmlElement
    @JsonProperty("debit")
    private String debit;


    public CardType() {

    }

    public CardType(Long id, String credit, String debit) {
        this.id = id;
        this.credit = credit;
        this.debit = debit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardType cardType = (CardType) o;
        return id == cardType.id &&
                Objects.equals(credit, cardType.credit) &&
                Objects.equals(debit, cardType.debit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credit, debit);
    }

}
