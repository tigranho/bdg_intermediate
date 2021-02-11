package com.bdg.airport_jpa.model;

import javax.persistence.*;
import java.time.LocalTime;
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Company company;
    @Column
    private LocalTime time_in;
    @Column
    private LocalTime time_out;
    @Column
    private String town_too;

    public Trip() {
    }

    public Trip(Company company, LocalTime time_in, LocalTime time_out, String town_too) {
        this.company = company;
        this.time_in = time_in;
        this.time_out = time_out;
        this.town_too = town_too;
    }

    public int getId() {
        return id;
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

    public Company getCompany() {
        return company;
    }


    public void setTime_in(LocalTime time_in) {
        this.time_in = time_in;
    }

    public void setTime_out(LocalTime time_out) {
        this.time_out = time_out;
    }

    public void setTown_too(String town_too) {
        this.town_too = town_too;
    }
}
