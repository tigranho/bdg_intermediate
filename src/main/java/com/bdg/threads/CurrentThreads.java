package com.bdg.threads;

import java.util.Random;

public class CurrentThreads {
    public static void main(String[] args) throws InterruptedException {
        int number = 0;
        final Thr tr = new Thr();

        for (int i = 0; i < 6; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    tr.randomValue(new Random().nextInt());
                }
            };
            Thread thread = new Thread(r);
            thread.start();
            thread.join();
        }

        System.out.println(tr.getValue());

    }
}

class Thr {

    int value;

    synchronized void randomValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

}

