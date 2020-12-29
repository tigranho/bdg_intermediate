package com.bdg;

import java.io.Serializable;

public class Beans implements Serializable {
    private int id;
    private String name;

    public Beans() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
