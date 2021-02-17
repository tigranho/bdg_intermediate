package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
public class Trip implements Comparable<Trip> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_number")
    private int tripNumber;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    @Column(name = "time_in")
    private LocalDateTime timeIn;
    @Column(name = "time_out")
    private LocalDateTime timeOut;
    @Column(name = "town_to")
    private String townTo;
    @Column(name = "town_from")
    private String townFrom;


    public Trip() {

    }


    public Trip(Company company, LocalDateTime timeIn, LocalDateTime timeOut, String townTo, String townFrom) {
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNumber=" + tripNumber +
                ", company=" + company +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", townTo='" + townTo + '\'' +
                ", townFrom='" + townFrom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Trip o) {
        return tripNumber - o.tripNumber;
    }
}
