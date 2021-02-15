package com.bdg.homework2.patterns.abstractFactory;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AbstractFactoryMain implements Comparator<String>{
    public static void main(String[] args)
    {
        System.out.println(CarFactory.buildCar(CarType.MICRO));
        System.out.println(CarFactory.buildCar(CarType.MINI));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));


    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
