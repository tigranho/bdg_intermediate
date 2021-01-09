package com.bdg.designPatterns.prototype;

public class PrototypePatternDemo {

    public static void main(String[] args) {

        Car transit = new Van("Transit");
        Car kalina = new Sedan("Kalina");

        System.out.println(transit.toString());
        System.out.println(kalina.toString());
    }
}
