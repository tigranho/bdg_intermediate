package com.bdg.airport.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Company implements Comparable<Company>{
    private int id;
    private String name;
    private LocalDate found_date;

    public Company() {
    }

    public Company(String name, LocalDate found_date) {
        this.name = name;
        this.found_date = found_date;
    }

    public Company(int id, String name, LocalDate found_date) {
        this.id = id;
        this.name = name;
        this.found_date = found_date;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFound_date(LocalDate found_date, DateTimeFormatter formatter) {
        this.found_date = found_date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFound_date() {
        return found_date;
    }

    public void setFound_date(LocalDate found_date) {
        this.found_date = found_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "name='" + name + '\'' +
                ", found_date=" + found_date +
                '}';
    }

    @Override
    public int compareTo(Company o) {
        return name.compareTo(o.name);
    }
}
