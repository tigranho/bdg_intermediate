package com.bdg.principles.composition;

import java.util.Date;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private Role role;

    public User(int id, String firstName, String lastName, String username, long salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        initJob(salary);
    }

    private void initJob(long salary) {
        role = new Role();
        role.setStartTame(new Date());
        role.setSalary(salary);
        if (role.getSalary() > 999L) {
            role.setRole("ADMIN");
        } else {
            role.setRole("USER");
        }
    }

    public Role getJob() {
        return role;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", job=" + role +
                '}';
    }
}

class Role {
    private String role;
    private long salary;
    private Date startTame;

    public Date getStartTame() {
        return startTame;
    }

    public void setStartTame(Date startTame) {
        this.startTame = startTame;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "role='" + role + '\'' +
                ", salary=" + salary +
                ", startJob=" + startTame +
                '}';
    }
}

