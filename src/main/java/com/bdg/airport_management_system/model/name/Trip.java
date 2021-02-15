package com.bdg.airport_management_system.model.name;
import com.bdg.airport_management_system.model.name.Company;

import java.time.LocalDateTime;

public class Trip {
private long id;
private Company company;
LocalDateTime time_in;
LocalDateTime time_out;
String town_from;
String town_to;

    public Trip(long id, Company company, LocalDateTime time_in, LocalDateTime time_out, String town_from, String town_to) {
        this.id = id;
        this.company = company;
        this.time_in = time_in;
        this.time_out = time_out;
        this.town_from = town_from;
        this.town_to = town_to;
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

    public LocalDateTime getTime_in() {
        return time_in;
    }

    public void setTime_in(LocalDateTime time_in) {
        this.time_in = time_in;
    }

    public LocalDateTime getTime_out() {
        return time_out;
    }

    public void setTime_out(LocalDateTime time_out) {
        this.time_out = time_out;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public String getTown_to() {
        return town_to;
    }

    public void setTown_to(String town_to) {
        this.town_to = town_to;
    }
}
