package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class Mercedes implements Car{
    @Override
    public void speed() {
        System.out.println("this is the speed() method inside Mercedes");
    }
}
