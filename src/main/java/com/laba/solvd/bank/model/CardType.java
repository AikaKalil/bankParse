package com.laba.solvd.bank.model;

import java.util.Objects;

public class CardType {
    private Long id;
    private String credit;
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
