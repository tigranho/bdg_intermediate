package com.bdg.airport.model;

public class Passenger {
    private int id;
    private String name;
    private String phone;
    private int addressId;

    public Passenger() {
    }

    public Passenger(String name, String phone, int addressId) {
        this.name = name;
        this.phone = phone;
        this.addressId = addressId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", addressId=" + addressId +
                '}';
    }

    public Passenger(int id, String name, String phone, int addressId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public int getAddresId() {
        return addressId;
    }

    public void setAddresId(int addresId) {
        this.addressId = addresId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
