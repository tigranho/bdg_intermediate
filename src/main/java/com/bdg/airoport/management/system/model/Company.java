package com.bdg.airoport.management.system.model;

import java.time.LocalDate;

public class Company {
    private long id;
    private String companyName;
    private LocalDate foundingDate;

    public Company(String companyName, LocalDate foundingDate) {
        this.companyName = companyName;
        this.foundingDate = foundingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
