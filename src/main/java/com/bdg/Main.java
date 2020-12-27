package com.bdg;

/**
 * @author Argishti
 */

/**
 * Class description: Simple java beans example
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

public class Main
{
    public static void main(String[] args)
    {
        Address address = new Address();
        address.setCountry("Armenia");
        address.setCity("Yerevan");
        address.setStreet("Nairi Zaryan");

        Employee employee = new Employee();
        employee.setId("001");
        employee.setFirstName("Karapet");
        employee.setLastName("Grigoryan");
        employee.setAddress(address);

        System.out.println(employee);

        employee = null;

        System.out.println(employee);
        System.out.println(address+"\n");

        Building building = new Building();
        building.setName("Home");
        building.setFloors(2);
        building.getAddress().setCountry("Armenia");
        building.getAddress().setCity("Yerevan");
        building.getAddress().setStreet("Sayat Nova");
        System.out.println(building);
        building = null;

        if(building != null)
        {
            System.out.println(building.getAddress());
        }
        System.out.println("Address does not exist");

    }
}
