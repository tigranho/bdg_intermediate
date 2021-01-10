package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class EngineFactory extends CarAbstractFactory {
    @Override
    Car getCar(String car) {

        return null;

    }

    @Override
    Engine getEngine(String engine) {
        if (engine == null) {
            return null;
        }
        if (engine.equalsIgnoreCase("LowPower")) {
            return   new LowPower();
        } else if (engine.equalsIgnoreCase("MidPower")) {
            return   new MidPower();
        } else if (engine.equalsIgnoreCase("HighPower")) {
            return   new HighPower();
        }
        return null;
    }
}
