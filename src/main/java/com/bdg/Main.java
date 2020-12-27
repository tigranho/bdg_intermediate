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

/**
 * Class Description: Simple Aggregation example
 */
class Employee
{
    private String id;
    private String firstName;
    private String lastName;

    //Aggreation example
    private Address address;

    public Employee()
    {

    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Address getAddress()
    {
        return this.address;
    }

    @Override
    public String toString()
    {
        return "Employee: [id: "+this.id+", first name: "+this.firstName+", last name: "+this.lastName+", address: "+this.address+"]";
    }
}

/**
 * Class Description: Simple Composition example
 */
class Building
{
    private String name;
    private int floors;
    private Address address;

    public Building()
    {
        address = new Address();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setFloors(int floors)
    {
        this.floors = floors;
    }

    public int getFloors()
    {
        return this.floors;
    }

    public Address getAddress()
    {
        return this.address;
    }

    @Override
    public String toString()
    {
        return "Building name: "+this.name+", This building has "+this.floors+" floors"+", it is located in "+this.address;
    }
}

class Address
{
    private String country;
    private String city;
    private String street;

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    @Override
    public String toString()
    {
        return this.country+"/"+this.city+"/"+this.street;
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
