package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends PrimaryKey {
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @OneToOne(mappedBy = "address")
    private Passenger passenger;

    public Address() {

    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
