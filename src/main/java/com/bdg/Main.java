package com.bdg;

import com.bdg.homework.Employee;
import com.bdg.homework.Passport;
import com.bdg.homework.Student;
import com.bdg.homework.University;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigran
 */
public class Main {

    public static void main(String[] args) {
         System.out.println("Test");
        // javaBean
        Student student = new Student();
        student.setId(1);
        student.setName("Ara");
        student.setAge(24);

        // Aggregation
        Passport passport = new Passport(15478,"AN021547896");
        Employee employee = new Employee(1,"Armen",passport);
        System.out.println(employee.getPassport().getGivenBy());
        System.out.println(employee.getPassport().getNumber());
        System.out.println(employee.getName());
        employee = null;
        // employee now is null, but passport exist
        System.out.println(passport.getNumber());

        // composition
        Student student1 = new Student(1,"Armen",18);
        Student student2 = new Student(2,"Karen",17);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student2);
        studentList.add(student1);
        University university = new University("Rau", "Armenia", studentList);
        List<Student> list = university.getStudentList();
        list.forEach(student3 -> System.out.println(student.getName()));





    }

}
