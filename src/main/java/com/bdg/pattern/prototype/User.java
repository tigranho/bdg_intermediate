package com.bdg.pattern.prototype;

public class User implements ProtoType {


    private int id;
    private String username;
    private double salary;

    public User(int id, String username, double salary) {
        this.id = id;
        this.username = username;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public ProtoType createClone() {
        return new User(id,username,salary);
    }


}
