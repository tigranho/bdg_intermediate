package com.bdg.pattern.immutable;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<String> work = new ArrayList<>();
        work.add("IPAM");
        work.add("Web front");

        Address address = new Address("Armenia", "Erevan", 15);
        ImmutableUser user = new ImmutableUser(1, "Valod", 27, address, work);
        System.out.println(user.toString());

        work.remove(0);
        work.add("EGS");
        address.setCity("New york");
        address.setCountry("USE");

        System.out.println(work);
        System.out.println(address);


        System.out.println("_________________________");
        System.out.println(user);


    }
}
