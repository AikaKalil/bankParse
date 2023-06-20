package com.laba.solvd.bank.model;

import java.util.Objects;

public class Position {
    private int id;
    private String positionName;

    public Position(){

    }

    public Position(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return id == position.id &&
                Objects.equals(positionName, position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positionName);
    }
}
