package com.bdg.examples;

public class Animal {
    private String species;
    private int age;


    public Animal(String species) {
        this.setSpecies(species);
    }

    public static void main(String[] args) {
        Animal animal = new Animal("aa");
        animal.setAge(-100);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().length() == 0) {
            throw new IllegalArgumentException("Species is required");
        }
        this.species=species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("age can not be a negative number");
        }
        this.age=age;
    }
}
