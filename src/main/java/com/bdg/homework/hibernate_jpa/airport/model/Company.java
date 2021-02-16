package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "company")
public class Company implements Comparable<Company> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "name")
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
