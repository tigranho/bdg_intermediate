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
    public static void main(String[] args) {
        Passport passport = new Passport(15478,"AN021547896");
        Employee employee = new Employee(1,"Armen",passport);
        System.out.println(employee.getPassport().getGivenBy());
        System.out.println(employee.getPassport().getNumber());
        System.out.println(employee.getName());
        employee = null;
        // employee now is null, but passport exist
        System.out.println(passport.getNumber());
    }
}
