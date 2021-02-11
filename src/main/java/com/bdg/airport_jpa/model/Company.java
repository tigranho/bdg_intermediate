package com.bdg.airport_jpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private LocalDate found_date;
    @OneToMany
    private Set<Trip>trips;

    public Company() {

    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public Company(String name, LocalDate found_date) {
        this.name = name;
        this.found_date = found_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFound_date() {
        return found_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFound_date(LocalDate found_date) {
        this.found_date = found_date;
    }
}
