package com.bdg.thread;

import java.util.Random;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        int number = 0;
        final ThreadTwo tr = new ThreadTwo();
        for (int i = 0; i < 6; i++) {
            Runnable r = () -> {
                tr.randomValue(new Random().nextInt(10)+1);
            };
            Thread thread = new Thread(r);
            thread.start();
            thread.join();
            number += tr.getValue();
            System.out.println("the first number " + tr.getValue());
        }
        System.out.println("total value of number" + number);

    }
}
