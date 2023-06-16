package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Branches {

    private int id;
    private String address;
    private List<Employees> employees;
    private List<ATMs> atms;

    public Branches(){

    }
    public Branches(int id, String address, List<Employees> employees, List<ATMs> atms) {
        this.id = id;
        this.address = address;
        this.employees = employees;
        this.atms = atms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<ATMs> getAtms() {
        return atms;
    }

    public void setAtms(List<ATMs> atms) {
        this.atms = atms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Branches branches = (Branches) o;
        return id == branches.id &&
                Objects.equals(address, branches.address) &&
                Objects.equals(employees, branches.employees) &&
                Objects.equals(atms, branches.atms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, employees, atms);
    }
}
