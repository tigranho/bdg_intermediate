package com.bdg.examples.buikder;

public class ZooKepper {
    public static void main(String[] args) {
        Food food = FoodFactory.getFood("zebra");
        food.consumed();
    }
}
