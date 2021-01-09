package com.bdg.designPatterns.singleton;



public class SharedCardBalance {

    private int balance = 0;

    private SharedCardBalance() {
    }



    private static final SharedCardBalance instance = new SharedCardBalance();

    public static SharedCardBalance getInstance() {
        return instance;
    }

    public synchronized void depositBalance(int sum) {
        balance += sum;
    }

    public synchronized boolean withdrawBalance(int sum) {
        if (balance > sum) {
            balance -= sum;
            return true;
        } else return false;
    }

    public synchronized int getBalance() {
        return balance;
    }

}
