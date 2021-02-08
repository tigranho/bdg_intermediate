package com.bdg.airoport.management.system.model;

import java.time.LocalDate;
import java.util.Set;

public class Company {
    private long id;
    private String companyName;
    private LocalDate foundingDate;
    private Set<Trip> tripSet;

    public Company(long id, String companyName, LocalDate foundingDate, Set<Trip> tripSet) {
        this.id = id;
        this.companyName = companyName;
        this.foundingDate = foundingDate;
        this.tripSet = tripSet;
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


    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
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
