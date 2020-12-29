package com.bdg.homework;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        Student student1 = new Student(1,"Armen",18);
        Student student2 = new Student(2,"Karen",17);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student2);
        studentList.add(student1);
        University university = new University("Rau", "Armenia", studentList);
        List<Student> list = university.getStudentList();
        for(Student student : list){
            System.out.println(student.getName());
        }
    }

}
