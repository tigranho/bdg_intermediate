package com.bdg.airport_jpa.model;

import javax.persistence.*;

@Entity
@Table(name ="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String country;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Column
    private String city;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

