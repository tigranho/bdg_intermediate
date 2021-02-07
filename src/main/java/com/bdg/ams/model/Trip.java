package com.bdg.ams.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Trip {

    private int tripNumber;
    private Company company;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private String townTo;
    private String townFrom;
    private Set<Passenger> passengers;


    public Trip() {

    }


    public Trip(Company company, LocalDateTime timeIn, LocalDateTime timeOut, String townTo, String townFrom) {
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
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


}
