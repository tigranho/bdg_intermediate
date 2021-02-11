package com.bdg.airport_jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    public Passenger() {
    }

    public Passenger(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Passenger(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

