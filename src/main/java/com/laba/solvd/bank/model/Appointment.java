package com.laba.solvd.bank.model;

import java.util.Date;
import java.util.Objects;

public class Appointment {
    private int id;
    private Date dateTime;

    public Appointment(){

    }

    public Appointment(int id, Date dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Appointment appointment = (Appointment) o;
        return id == appointment.id && Objects.equals(dateTime, appointment.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime);
    }
}
