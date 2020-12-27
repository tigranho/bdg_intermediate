package com.bdg;

public class Address
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
