package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class CarFactory extends CarAbstractFactory {
    @Override
    Car getCar(String car) {
        if (car == null) {
            return null;
        }
        if (car.equalsIgnoreCase("AstonMartin")) {
            return new AstonMartin();
        } else if (car.equalsIgnoreCase("Mercedes")) {
            return new Mercedes();
        } else if (car.equalsIgnoreCase("BMW")) {
            return new BMW();
        }
        return null;
    }

    @Override
    Engine getEngine(String engine) {
        return null;
    }
}
