package com.bdg.homework4.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

public class Company {
    int id;
    String name;
    Date date;
    Set<Trip> tripSet;

    public Company() {
    }

    public Company(String name, Date date, Set<Trip> tripSet) {
        this.name = name;
        this.date = date;
        this.tripSet = tripSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
