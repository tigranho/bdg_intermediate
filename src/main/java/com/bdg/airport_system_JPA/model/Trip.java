package com.bdg.airport_system_JPA.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
@Getter
@Setter
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
    @Column(name = "time_in")
    private LocalDateTime timeIn;
    @Column(name = "time_out")
    private LocalDateTime timeOut;
    @Column(name = "town_to")
    private String townTo;
    @Column(name = "town_from")
    private String townFrom;

    public Trip(Company company, LocalDateTime timeIn, LocalDateTime timeOut, String townTo, String townFrom) {
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
    }

    @Override
    public String toString() {
        return "Trip { " +
                " company: " + company +
                ", timeIn: " + timeIn +
                ", timeOut: " + timeOut +
                ", townTo: " + townTo +
                ", townFrom: " + townFrom +
                " }";
    }
}
