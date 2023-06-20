package com.laba.solvd.bank.model;

import java.util.List;
import java.util.Objects;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> account;
    private List<Appointment> appointment;

    public Customer(){

    }
    public Customer(int id, String firstName, String lastName, List<Account> account, List<Appointment> appointment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.appointment = appointment;
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

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(account, customer.account) &&
                Objects.equals(appointment, customer.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, account, appointment);
    }
}
