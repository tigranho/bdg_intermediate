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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "pass_city", referencedColumnName = "city"),
            @JoinColumn(name = "pass_country", referencedColumnName = "country")
    })
    private Address address;

    @Override
    public String toString() {
        return "Passenger { " +
                "id: " + id +
                ", name: " + name +
                ", phone: " + phone +
                ", address: " + address +
                " }";
    }

}
