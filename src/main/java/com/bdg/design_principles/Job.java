package com.bdg.design_principles;
/**
 * @author Artur
 */
public class Job {
    private String role;
    private long salary;
    private int id;

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public long getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
