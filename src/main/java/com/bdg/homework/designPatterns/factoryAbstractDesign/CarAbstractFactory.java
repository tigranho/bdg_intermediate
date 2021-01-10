package com.bdg.homework.designPatterns.factoryAbstractDesign;

public abstract class CarAbstractFactory {
    abstract Car getCar(String car);
    abstract Engine getEngine(String engine);
}
