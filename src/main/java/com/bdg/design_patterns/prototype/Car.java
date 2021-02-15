package com.bdg.design_patterns.prototype;

public abstract class Car implements Cloneable {

    private String model;
    private int seatCount;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }


    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    @Override
    public String toString() {
        return "Car model: " + getModel() + ", seat count: " + getSeatCount();
    }
}
