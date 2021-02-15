package com.bdg.DesignPatterns.FactoryPattern.FilterPattern;

public class Person {
    private String name;
    private String gender;
    private String work;

    public Person(String name, String gender, String work){
        this.name = name;
        this.gender = gender;
        this.work = work;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getWork() {
        return work;
    }
}

