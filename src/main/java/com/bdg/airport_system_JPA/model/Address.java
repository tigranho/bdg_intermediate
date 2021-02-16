package com.bdg.airport_system_JPA.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String city;
    @Column
    private String country;

    @OneToMany(targetEntity = Passenger.class, mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Passenger> passengerSet = new HashSet<>();

    public Address(String town, String country) {
        this.city = town;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address { " +
                "id: " + id +
                ", city: " + city +
                ", country: " + country +
                " }";
    }
}
