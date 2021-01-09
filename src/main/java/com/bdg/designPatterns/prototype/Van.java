package com.bdg.designPatterns.prototype;

public class Van extends  Car{

    public Van(String type) {
        this.setSeatCount(15);
        this.setModel(type);
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
