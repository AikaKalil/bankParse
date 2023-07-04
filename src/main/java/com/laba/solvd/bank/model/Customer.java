package com.laba.solvd.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@JsonRootName("customer")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    @XmlAttribute(name="id")
    private Long id;
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @JsonProperty("accounts")
    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
    private List<Account> accounts;

    @JsonProperty("appointment")
    @XmlElementWrapper(name = "appointments")
    @XmlElement(name = "appointment")
    private List<Appointment> appointments;

    public Customer() {

    }

    public Customer( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return accounts;
    }

    public void setAccount(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Appointment> getAppointment() {
        return appointments;
    }

    public void setAppointment(List<Appointment> appointments) {
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
        Customer customer = (Customer) o;
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
