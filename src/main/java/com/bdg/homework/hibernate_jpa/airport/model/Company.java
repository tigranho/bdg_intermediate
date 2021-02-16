package com.bdg.homework.hibernate_jpa.airport.model;

import java.time.LocalDate;

public class Company implements Comparable<Company> {
    private  int id;
    private String name;
    private LocalDate foundingDate;

    public Company() {

    }

    public Company(String name, LocalDate foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
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
