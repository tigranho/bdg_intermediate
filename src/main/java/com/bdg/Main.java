package com.bdg;

/**
 * @author Argishti
 */

class Person
{
    private String name, surname;
    private int age, height;

    void setName(String name)
    {
        this.name = (name == null || surname.trim().length()==0) ? null: surname;
    }

    String getName()
    {
        return this.name;
    }

    void setSurname(String surname)
    {
        this.surname = (surname == null || surname.trim().length()==0) ? null: surname;
    }

    String getSurname()
    {
        return this.surname;
    }

    void setAge(int age)
    {
        if(age < 0)
        {
            throw new IllegalArgumentException("Age can not be negative");
        }
        this.age = age;
    }

    int getAge()
    {
        return this.age;
    }

    void setHeight(int height)
    {
        if(height <= 0)
        {
            throw new IllegalArgumentException("Height can not be negative or zero");
        }
        this.height = height;
    }

    int getHeight()
    {
        return this.height;
    }
}


public class Main {

    public static void main(String[] args) {
        System.out.println("Test");
    }

}
