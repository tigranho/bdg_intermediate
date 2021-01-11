package com.bdg.homework2.patterns.abstractFactory;

public class MicroCar extends Car{
    MicroCar(Location location)
    {
        super(CarType.MICRO, location);
        construct();
    }
    @Override
    protected void construct()
    {
        System.out.println("Connecting to Micro Car ");
    }
}
