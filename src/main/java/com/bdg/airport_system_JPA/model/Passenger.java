package com.bdg.airport_system_JPA.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String phone;
    @OneToOne
    private Address address;

    public Passenger(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
