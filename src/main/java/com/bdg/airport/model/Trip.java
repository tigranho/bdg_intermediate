package com.bdg.airport.model;

import java.time.LocalTime;

public class Trip {
    private int id;
    private int company_id;
    private LocalTime time_in;
    private LocalTime time_out;
    private String town_too;

    public Trip(int id, int company_id, LocalTime time_in, LocalTime time_out, String town_too, String town_from) {
        this.id = id;
        this.company_id = company_id;
        this.time_in = time_in;
        this.time_out = time_out;
        this.town_too = town_too;
        this.town_from = town_from;
    }

    private String town_from;

    public void setTime_in(LocalTime time_in) {
        this.time_in = time_in;
    }

    public void setTime_out(LocalTime time_out) {
        this.time_out = time_out;
    }

    public void setTown_too(String town_too) {
        this.town_too = town_too;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public LocalTime getTime_in() {
        return time_in;
    }

    public LocalTime getTime_out() {
        return time_out;
    }

    public String getTown_too() {
        return town_too;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyid(int companyid) {
        this.company_id = companyid;
    }

    public int getId() {
        return id;
    }

    public int getCompanyid() {
        return company_id;
    }

    public String getTown_from() {
        return town_from;
    }

}

