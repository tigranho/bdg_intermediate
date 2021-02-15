package com.bdg.airport_system.model;

public class Address {

    private int id;
    private String town;
    private String country;

    public Address(){

    }


    public Address(String town, String country) {
        this.town = town;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address { " +
                "id: " + id +
                ", town: " + town +
                ", country: " + country +
                " }";
    }
}
