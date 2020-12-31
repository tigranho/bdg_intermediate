package com.bdg.pattern.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableUser {

    private final long id;
    private final String name;


    private final int age;

    private final Address address;

    private final List<String> jobs;

    public ImmutableUser(long id, String name, int age, Address address, ArrayList<String> jobs) throws CloneNotSupportedException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = (Address) address.clone();


        this.jobs = new ArrayList<>(jobs);
    }


    @Override
    public String toString() {
        return "ImmutableUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addres=" + address +
                ", jobs=" + jobs +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public List<String> getJobs() {
        return Collections.unmodifiableList(jobs);
    }
}
