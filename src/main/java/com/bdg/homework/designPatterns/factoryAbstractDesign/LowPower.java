package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class LowPower implements Engine {
    @Override
    public void power() {
        System.out.println("this is the power()  method inside LowPower");

    }
}
