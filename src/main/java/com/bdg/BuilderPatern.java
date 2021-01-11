package com.bdg;

public class BuilderPatern {

    public static void main(String[] args) {
        MyCar car = new MyCar.Builder("Tesla").setColor("black").setMaxSpeed(300).build();
        System.out.println(car);
    }
}

class MyCar {
    private String name;
    private String color;
    private int maxSpeed;

    @Override
    public String toString() {
        return "MyCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    private MyCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
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

    static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

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

        public MyCar build() {
            return new MyCar(this);
        }
    }
}
