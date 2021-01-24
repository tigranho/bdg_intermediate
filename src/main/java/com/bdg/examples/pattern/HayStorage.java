package com.bdg.examples.pattern;

import com.bdg.examples.Animal;

public class HayStorage extends Animal {
    private static final HayStorage instance = new HayStorage();
    private int quantity = 0;

    private HayStorage() {
     super("test");
    }

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount)
            return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getQuantity() {
        return quantity;
    }
}
