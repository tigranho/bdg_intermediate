package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class FactoryProducer {
    public static CarAbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("CAR")) {
            return new CarFactory();
        } else if (choice.equalsIgnoreCase("ENGINE")) {
            return new EngineFactory();
        }
        return null;
    }
}
