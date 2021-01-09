package com.bdg.designPatterns.factory;

public abstract class Petrol {

    private int amount;

    public Petrol(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    public abstract void consumed();
}
