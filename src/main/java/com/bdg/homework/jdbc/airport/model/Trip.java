package com.bdg.homework.jdbc.airport.model;

import java.time.LocalDateTime;

public class Trip implements Comparable<Trip> {

    private int tripNumber;
    private Company company;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private String townTo;
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
