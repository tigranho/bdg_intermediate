package com.bdg.airport_system_JPA.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Address(String town, String country) {
        this.city = town;
        this.country = country;
    }
}
