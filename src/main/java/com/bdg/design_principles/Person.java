package com.bdg.design_principles;
/**
 * @author Artur
 */

/**
 * Simple composition example
 */
public class Person {
    //composition has-a relationship
    private Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(2500L);
    }

    public long getSalary() {
        return job.getSalary();
    }
}
