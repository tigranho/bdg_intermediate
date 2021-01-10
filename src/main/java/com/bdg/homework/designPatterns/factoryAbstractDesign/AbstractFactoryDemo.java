package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CarAbstractFactory carAbstractFactory = FactoryProducer.getFactory("Car");
        //get an object of Shape Circle
        Car car1 = carAbstractFactory.getCar("AstonMartin");
        car1.speed();
        Car car2 = carAbstractFactory.getCar("BMW");
        car2.speed();
        Car car3 = carAbstractFactory.getCar("Mercedes");
        car3.speed();

        CarAbstractFactory carAbstractFactoryForEngine = FactoryProducer.getFactory("Engine");


        Engine engine1 = carAbstractFactoryForEngine.getEngine("HighPower");
        engine1.power();
        Engine engine2 = carAbstractFactoryForEngine.getEngine("MidPower");
        engine2.power();
        Engine engine3 = carAbstractFactoryForEngine.getEngine("LowPower");
        engine3.power();

    }
}
