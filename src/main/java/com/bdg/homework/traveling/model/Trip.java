package com.bdg.homework.traveling.model;

import sun.util.resources.LocaleData;

import java.sql.Date;
import java.time.LocalDateTime;

public class Trip {

    private int tripNumber;
    private Date time_In;
    private Date time_Out;
    private String town_From;
    private String town_TO;
    private int id;

    public Date getTime_In() {
        return time_In;
    }

    public void setTime_In(Date time_In) {
        this.time_In = time_In;
    }

    public Date getTime_Out() {
        return time_Out;
    }

    public void setTime_Out(Date time_Out) {
        this.time_Out = time_Out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip() {
    }

    public Trip(int tripNumber, Date time_In, Date time_Out, String town_From, String town_TO) {
        this.tripNumber = tripNumber;
        this.time_In = time_In;
        this.time_Out = time_Out;
        this.town_From = town_From;
        this.town_TO = town_TO;

    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
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

      @Override
    public String toString() {
        return "Trip{" +
                "tripNumber=" + tripNumber +
                ", time_In=" + time_In +
                ", time_Out=" + time_Out +
                ", town_From='" + town_From + '\'' +
                ", town_TO='" + town_TO + '\''  +
                '}';
    }
}
