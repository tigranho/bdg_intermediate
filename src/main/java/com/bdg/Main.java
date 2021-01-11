package com.bdg;
import com.bdg.allcalsses.Animal;
import com.bdg.allcalsses.Bottle;
import com.bdg.allcalsses.Dog;

import  java.util.*;

/**
 * @author Tigran
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello java");
        foo(new Dog());
        Bottle.Ship ship = new Bottle.Ship();
    }


    public static void foo(Animal animal) {
        animal.move();
    }
}
