package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Customers {
    private int id;
    private String firstName;
    private String lastName;
    private List<Accounts> accounts;
    private List<Appointments> appointments;

    public Customers(){

    }
    public Customers(int id, String firstName, String lastName, List<Accounts> accounts, List<Appointments> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = accounts;
        this.appointments = appointments;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customers customer = (Customers) o;
        return id == customer.id &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(accounts, customer.accounts) &&
                Objects.equals(appointments, customer.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, accounts, appointments);
    }
}
