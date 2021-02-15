package com.bdg.DesignPatterns.FactoryPattern.BuilderPattern;

public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());;
        return meal;
    }
}
