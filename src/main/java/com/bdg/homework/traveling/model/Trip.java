package com.bdg.homework.traveling.model;

import sun.util.resources.LocaleData;

import java.time.LocalDateTime;

public class Trip {

    private int tripNumber;
    private LocalDateTime time_In;
    private LocalDateTime time_Out;
    private String town_From;
    private String town_TO;
    private Company organised_company;

    public Trip() {
    }

    public Trip(int tripNumber, LocalDateTime time_In, LocalDateTime time_Out, String town_From, String town_TO, Company organised_company) {
        this.tripNumber = tripNumber;
        this.time_In = time_In;
        this.time_Out = time_Out;
        this.town_From = town_From;
        this.town_TO = town_TO;
        this.organised_company = organised_company;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public LocalDateTime getTime_In() {
        return time_In;
    }

    public void setTime_In(LocalDateTime time_In) {
        this.time_In = time_In;
    }

    public LocalDateTime getTime_Out() {
        return time_Out;
    }

    public void setTime_Out(LocalDateTime time_Out) {
        this.time_Out = time_Out;
    }

    public String getTown_From() {
        return town_From;
    }

    public void setTown_From(String town_From) {
        this.town_From = town_From;
    }

    public String getTown_TO() {
        return town_TO;
    }

    public void setTown_TO(String town_TO) {
        this.town_TO = town_TO;
    }

    public Company getOrganised_company() {
        return organised_company;
    }

    public void setOrganised_company(Company organised_company) {
        this.organised_company = organised_company;
    }
}
