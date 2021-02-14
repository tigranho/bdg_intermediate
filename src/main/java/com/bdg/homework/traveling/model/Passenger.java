package com.bdg.homework.traveling.model;

import java.util.Set;

public class Passenger {
    private String name;
    private int phoneNumber;
   // private Address address;
   // private Set<Trip> trips ;
    private int id;

    public Passenger() {
    }

    public Passenger(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    //    this.address = address;

    }

  /*  public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber  +
                '}';
    }
}
