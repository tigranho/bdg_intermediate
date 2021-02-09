package com.bdg.homework4.entity;

public class Passenger {
    int id;
    private String name;
    private String phone;
    private int address_id;

    public Passenger() {
    }

    public Passenger(String name, String phone,int address) {
        this.name = name;
        this.phone = phone;
        this.address_id = address;
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

    public int getAddress() {
        return address_id;
    }

    public void setAddress(int address) {
        this.address_id = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address_id=" + address_id +
                '}';
    }
}
