package com.bdg.homework.airport.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Company implements Comparable<Company> {
    private  int id;
    private String name;
    private LocalDateTime foundingDate;

    public Company() {

    }

    public Company(String name, LocalDateTime foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDateTime foundingDate) {
        this.foundingDate = foundingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }

    @Override
    public int compareTo(Company o) {
        return name.compareTo(o.name);
    }
}
