package com.bdg.designPatterns.factory;

public class Premium extends Petrol{
    public Premium(int amount) {
        super(amount);
    }
    @Override
    public void consumed() {
        System.out.println(getAmount() + " petrol spent, type: Premium");
    }
}
