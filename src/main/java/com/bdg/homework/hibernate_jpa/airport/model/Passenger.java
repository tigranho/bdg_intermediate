package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger extends PrimaryKey implements Comparable<Passenger> {


    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public Passenger() {

    }

    public Passenger(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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
    public int compareTo(Passenger o) {
        return getId() - o.getId();
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
