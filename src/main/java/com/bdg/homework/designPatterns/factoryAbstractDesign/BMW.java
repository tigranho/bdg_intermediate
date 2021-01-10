package com.bdg.homework.designPatterns.factoryAbstractDesign;

public class BMW  implements Car{
    @Override
    public void speed() {
        System.out.println("this is the speed() method inside BMW");
    }
}
