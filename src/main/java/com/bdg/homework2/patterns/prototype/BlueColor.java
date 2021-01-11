package com.bdg.homework2.patterns.prototype;

public class BlueColor extends Color{

    public BlueColor()
    {
        this.colorName = "blue";
    }

    @Override
    void addColor() {
        System.out.println("Blue color added");
    }
}
