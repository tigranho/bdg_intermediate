package com.bdg.pattern.builder;

public class MyBuilder {
    public static void main(String[] args) {
        Car car = new Car.Builder("Audi").setMaxSpeed(200).setColor("read").build();
        System.out.println(car);
    }
}

class Car {
    private String name;
    private String color;
    private int maxSpeed;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private Car(Builder builder) {
        this.color = builder.color;
        this.name = builder.name;
        this.maxSpeed = builder.maxSpeed;
    }

    static class Builder {
        private String name;
        private String color = "blue";
        private int maxSpeed = 120;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
