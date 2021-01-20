package com.bdg.thread;

import java.util.Random;

public class RandomNumberThread implements Runnable {


    private final Random random;
    private int sum;

    public RandomNumberThread() {
        this.sum = 0;
        this.random = new Random();
    }


    @Override
    public void run() {
        int number = random.nextInt(10) + 1;
        System.out.println("number:" + number);
        synchronized (this) {
            sum += number;
        }
    }

    public int getSum() {
        return sum;
    }
}
