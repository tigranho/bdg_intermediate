package com.bdg.pattern.immutable;

public class Address implements Cloneable {

    private String country;
    private String city;
    private int home;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Address(String country, String city, int home) {
        this.country = country;
        this.city = city;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", home=" + home +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }
}
