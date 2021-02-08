package com.bdg.airportManagementSystem.model;

import com.bdg.airportManagementSystem.model.Company;

import java.time.LocalTime;

public class Trip {
    private long id;
    private Company company;
    private String townTo;
    private String townFrom;
    private LocalTime timeIn;
    private LocalTime timeOut;

    public Trip() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", company=" + company +
                ", townTo='" + townTo + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                '}';
    }
}
