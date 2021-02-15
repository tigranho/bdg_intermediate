package com.bdg.design_patterns.prototype;

public class Sedan extends Car{

    public Sedan(String type) {
        this.setSeatCount(4);
        this.setModel(type);
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
