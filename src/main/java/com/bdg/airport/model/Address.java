package com.bdg.airport.model;
public class Address {
    private int id;
    private String country;
    private String city;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Address() {
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
