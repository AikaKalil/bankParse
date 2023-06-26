package com.laba.solvd.bank.model;

import java.util.Objects;

public class ATM {
    private Long id;
    private String location;

    public ATM() {

    }

    public ATM(Long id, String location) {
        this.id = id;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ATM atm = (ATM) o;
        return id == atm.id && Objects.equals(location, atm.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location);
    }
}
