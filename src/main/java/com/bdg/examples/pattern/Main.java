package com.bdg.examples.pattern;

import com.bdg.examples.Animal;

public class Main {
    public static void main(String[] args) {
        AnimalBuilder builder = new AnimalBuilder()
                .setAge(4)
                .setSpecies("duck");
        Animal animal = builder.build();
        System.out.println(animal.getSpecies());
    }
}
