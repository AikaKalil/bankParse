package com.laba.solvd.bank.model;
import java.util.Objects;

public class ATMs {
    private int id;
    private String location;

    public ATMs(){

    }
    public ATMs(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        ATMs atm = (ATMs) o;
        return id == atm.id && Objects.equals(location, atm.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location);
    }
}
