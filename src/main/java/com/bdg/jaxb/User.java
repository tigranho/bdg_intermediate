package com.bdg.jaxb;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "users")
@XmlType(propOrder = {"id", "firstName", "lastName"})
public class User {


    private Long id;
    private String firstName;
    private String lastName;

    private Address address;


    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

        public Address getAddress() {
        return address;
    }

    @XmlTransient
    public void setAddress(Address address) {
        this.address = address;
    }
}
