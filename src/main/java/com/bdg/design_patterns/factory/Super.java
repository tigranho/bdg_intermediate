package com.bdg.design_patterns.factory;

public class Super extends Petrol{
    public Super(int amount) {
        super(amount);
    }

    @Override
    public void consumed() {
        System.out.println(getAmount() + " petrol spent, type: Super");
    }
}
