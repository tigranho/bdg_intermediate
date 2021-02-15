package com.bdg.airport_management_system.model.name;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Company {
    private int id;
    private String name;
    private LocalDate foundingDate;

    public Company(){

    }

    public Company(String companyDatum, LocalDate foundDate) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
