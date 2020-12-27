package com.bdg;

/**
 * Class Description: Simple Composition example
 */
public class Building
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
