package com.bdg.homework5.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*@NamedEntityGraph(
        name = "graph.passengerSet",
        attributeNodes = @NamedAttributeNode("passengers")
)*/
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column
    private String country;

    @Column
    private String city;

    @OneToMany(mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Passenger> passengerSet = new HashSet<>();

    public void addPassenger(Passenger passenger) {
        passengerSet.add(passenger);
        passenger.setAddress(this);
    }

    public void removePassenger(Passenger passenger) {
        passengerSet.remove(passenger);
        passenger.setAddress(null);
    }

    public Set<Passenger> getPassengerSet() {
        return passengerSet;
    }

    public void setPassengerSet(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }

    public Address() {
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                 passengerSet+
                '}';
    }
}
