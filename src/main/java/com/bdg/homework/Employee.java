package com.bdg.homework;

/**
 * @author Ara
 * Aggregation
 */
public class Employee {
    private Integer id;
    private String name;
    // Creating Has-a relationship with Passport class
    private Passport passport;

    public Employee(Integer id, String name, Passport passport) {
        this.id = id;
        this.name = name;
        this.passport = passport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
