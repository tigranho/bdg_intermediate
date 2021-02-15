package com.bdg.design_patterns.factory;

public class Regular extends Petrol{
    public Regular(int amount) {
        super(amount);
    }

    @Override
    public void consumed() {
        System.out.println(getAmount() + " petrol spent, type: Regular");
    }


}
