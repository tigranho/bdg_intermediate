package com.bdg.DesignPatterns.FactoryPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDemo {public static void main(String[] args) {
    List<Person> persons = new ArrayList<Person>();

    persons.add(new Person("Robert","Male", "IT"));
    persons.add(new Person("Artur", "Male", "Doctor"));
    persons.add(new Person("Laura", "Female", "Doctor"));
    persons.add(new Person("Diana", "Female", "IT"));
    persons.add(new Person("Aram", "Male", "IT"));
    persons.add(new Person("Karina", "Female", "IT"));

    Criteria male = new CriteriaMale();
    Criteria female = new CriteriaFemale();
    Criteria work = new CriteriaWork();
    Criteria workMale = new AddCriteria(work, male);
    Criteria workOrFemale = new OrCriteria(work, female);

    System.out.println("Males: ");
    printPersons(male.meetCriteria(persons));

    System.out.println("\nFemales: ");
    printPersons(female.meetCriteria(persons));

    System.out.println("\nWork Males: ");
    printPersons(workMale.meetCriteria(persons));

    System.out.println("\nWork Or Females: ");
    printPersons(workOrFemale.meetCriteria(persons));
}

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Work : " + person.getWork() + " ]");
        }
    }
}
