package com.bdg.homework.hibernate_jpa.airport.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PrimaryKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public PrimaryKey() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
