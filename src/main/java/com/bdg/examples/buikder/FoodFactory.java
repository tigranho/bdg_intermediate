package com.bdg.examples.buikder;

public class FoodFactory {
    public static Food getFood(String animalNamae) {
        switch (animalNamae) {
            case "zebra":
                return new Hay(100);

            case "rabbit":
                return new Pellets(5);

        }
        throw new UnsupportedOperationException("animal"+animalNamae);
    }

}
