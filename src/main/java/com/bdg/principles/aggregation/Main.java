package com.bdg.principles.aggregation;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setCountry("England");
        address.setCity("Manchester");
        address.setProvince("North West England");
        address.setStreet("Town Ferguson");
        address.setAddress("A55/15");

        User user = new User(1, "Jim", "Beglin", "Jim777", address);
        System.out.println(user);

    }
}
