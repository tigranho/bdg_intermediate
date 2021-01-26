package com.bdg.examples.pattern;

import com.bdg.examples.Animal;

import java.util.List;

public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFood(List<String> favoriteFood) {
        this.favoriteFoods = favoriteFood;
        return this;
    }

    public Animal build() {
        return new Animal(species);
    }

}
