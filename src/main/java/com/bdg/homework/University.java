package com.bdg.homework;

import java.util.List;

/**
 * @author  Ara
 * class for composition
 */
public class University {
    private String name;
    private String country;
    private final List<Student> studentList;

    public University(String name, String country, List<Student> studentList) {
        this.name = name;
        this.country = country;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}
