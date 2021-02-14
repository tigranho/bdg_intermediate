package com.bdg.homework.traveling.model;

import java.sql.Date;
import java.time.LocalDate;

import static java.lang.String.valueOf;

public class Company {
    private String name;
    private Date localeDate;
    private int id;

    public int getId() {
        return id;
    }

    public Company() {
    }

    public Company(String name, Date localeData) {
        this.name = name;
        this.localeDate = localeData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getLocaleDate() {
        return localeDate;
    }

    public void setLocaleDate(Date localeDate) {
        this.localeDate = localeDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", localeData=" + localeDate +
                '}';
    }

    public void setId(int id) {
    }
}
