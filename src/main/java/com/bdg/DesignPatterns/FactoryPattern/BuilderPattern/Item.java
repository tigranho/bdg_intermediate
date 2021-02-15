package com.bdg.DesignPatterns.FactoryPattern.BuilderPattern;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
