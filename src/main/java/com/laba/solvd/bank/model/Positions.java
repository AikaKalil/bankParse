package com.laba.solvd.bank.model;

import java.util.Objects;

public class Positions {
    private int id;
    private String positionName;
    private Employees employee;

    public Positions(){

    }

    public Positions(int id, String positionName, Employees employee) {
        this.id = id;
        this.positionName = positionName;
        this.employee = employee;
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

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positions positions = (Positions) o;
        return id == positions.id &&
                Objects.equals(positionName, positions.positionName) &&
                Objects.equals(employee, positions.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positionName, employee);
    }
}
