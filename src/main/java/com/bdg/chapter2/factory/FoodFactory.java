package com.bdg.chapter2.factory;

public class FoodFactory  extends AbstractFactory {

    @Override
    public Food getFood(String animalName) {
        switch (animalName) {
            case "zebra":
                return new Hay(100);
            case "rabbit":
                return new Pellets(5);
            case "goat":
                return new Pellets(30);
            case "polar bear":
                return new Fish(10);
        }
        throw new UnsupportedOperationException("Unsupported animal: " + animalName);
    }
}
