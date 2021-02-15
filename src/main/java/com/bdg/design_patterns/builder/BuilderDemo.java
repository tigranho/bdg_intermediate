package com.bdg.design_patterns.builder;

public class BuilderDemo {
    public static void main(String[] args) {


        Car gazel = new Car.CarBuilder().setModelName("Gazel")
                .setMAX_SPEED(83)
                .setNumberOFSeats(15)
                .Build();
    }
}
