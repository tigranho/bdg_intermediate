package com.bdg.homework.threads.producer_consumer.model;

public class Box {
    private int number;
    private String name;

    public Box(final int number, final String name) {
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
