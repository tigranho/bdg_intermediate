package com.bdg.ArrayList;

public class Flowers {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flowers(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Flowers1{" +
                "name='" + name + '\'' +
                '}';
    }
}
