package com.bdg.homework5.entity;

import com.bdg.homework5.entity.Trip;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private String name;

    @Basic
    //@Temporal(TemporalType.DATE)
    Date dateOfFound;

    @OneToMany(mappedBy = "trip",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    Set<Trip> tripSet = new HashSet<>();

    public Company() {
    }

    public void addTrip(Trip trip) {
        tripSet.add(trip);
        trip.setCompany(this);
    }

    public void removePassenger(Trip trip) {
        tripSet.remove(trip);
        trip.setCompany(null);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return dateOfFound;
    }

    public void setDate(Date date) {
        this.dateOfFound = date;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public Company(String name, Date date) {
        this.name = name;
        this.dateOfFound = date;
    }
}
