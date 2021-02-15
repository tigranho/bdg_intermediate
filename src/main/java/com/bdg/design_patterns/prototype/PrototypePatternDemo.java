package com.bdg.design_patterns.prototype;

public class PrototypePatternDemo {

    public static void main(String[] args) {

        Car transit = new Van("Transit");
        Car kalina = new Sedan("Kalina");

        System.out.println(transit.toString());
        System.out.println(kalina.toString());
    }
}
