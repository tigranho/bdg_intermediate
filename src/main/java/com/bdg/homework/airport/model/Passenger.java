package com.bdg.homework.airport.model;

public class Passenger implements Comparable<Passenger> {
    private int id;
    private String name;
    private String phone;
    private Address address;


    public Passenger() {

    }


    public Passenger( String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Passenger o) {
        return name.compareTo(o.name);
    }
}
