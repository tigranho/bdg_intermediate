package com.bdg.homework1;

/**
 * @author Ara
 * JavaBean Example
 */
public class Student implements java.io.Serializable{
    private Integer id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("Ara");
        student.setAge(24);
    }
}
