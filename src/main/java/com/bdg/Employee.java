package com.bdg;

/**
 * Class Description: Simple Aggregation example
 */
public class Employee
{
    private String id;
    private String firstName;
    private String lastName;

    //Aggreation example
    private Address address;

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
