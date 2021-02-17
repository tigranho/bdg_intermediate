package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company extends PrimaryKey implements Comparable<Company> {

    @Column(name = "name")
    private String name;
    @Column(name = "found_date")
    private LocalDate foundingDate;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private Set<Trip> trips;

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
