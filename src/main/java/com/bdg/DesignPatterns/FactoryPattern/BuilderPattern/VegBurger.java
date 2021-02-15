package com.bdg.DesignPatterns.FactoryPattern.BuilderPattern;

public class VegBurger extends Burger {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
