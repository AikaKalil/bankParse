package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Branch {

    private Long id;
    private String address;
    private List<Employee> employee;
    private List<ATM> atm;

    public Branch() {

    }

    public Branch(Long id, String address, List<Employee> employee, List<ATM> atm) {
        this.id = id;
        this.address = address;
        this.employee = employee;
        this.atm = atm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<ATM> getAtm() {
        return atm;
    }

    public void setAtm(List<ATM> atm) {
        this.atm = atm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Branch branch = (Branch) o;
        return id == branch.id &&
                Objects.equals(address, branch.address) &&
                Objects.equals(employee, branch.employee) &&
                Objects.equals(atm, branch.atm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, employee, atm);
    }
}
