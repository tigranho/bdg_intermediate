package com.bdg.threads;

import java.util.Random;

public class CurrentThreads {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };


    }
}


class RandomNumber {

    private int randomNumber;

    public synchronized void randomNumbers() {
        this.randomNumber = new Random().nextInt();
    }

    public synchronized int getRandomNumber() {
        return this.randomNumber;
    }

}
