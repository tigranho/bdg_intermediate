package com.bdg.designPatterns.builder;

public final class Car {
    private final String modelName;
    private final int MAX_SPEED;
    private final int numberOFSeats;

    public Car(String modelName, int MAX_SPEED, int numberOFSeats) {
        this.modelName = modelName;
        this.MAX_SPEED = MAX_SPEED;
        if (numberOFSeats < 2) {
            throw new RuntimeException("min number of seats is 2");
        }
        this.numberOFSeats = numberOFSeats;

    }

    public String getModelName() {
        return modelName;
    }

    public int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public int getNumberOFSeats() {
        return numberOFSeats;
    }

    public static class CarBuilder {
        private String modelName;
        private int MAX_SPEED;
        private int numberOFSeats;

        public CarBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public CarBuilder setMAX_SPEED(int MAX_SPEED) {
            this.MAX_SPEED = MAX_SPEED;
            return this;
        }

        public CarBuilder setNumberOFSeats(int numberOFSeats) {
            this.numberOFSeats = numberOFSeats;
            return this;
        }

        public Car Build() {
            return new Car(modelName, MAX_SPEED, numberOFSeats);
        }
    }


}
