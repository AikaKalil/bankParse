package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Position {
    private Long id;
    private String positionName;
    private List<Employee> employee;
    public Position() {

    }
    public Position(Long id, String positionName, List<Employee> employee) {
        this.id = id;
        this.positionName = positionName;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public List<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(List<Employee> employee) {
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
        Position position = (Position) o;
        return id == position.id &&
                Objects.equals(positionName, position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positionName);
    }
}
