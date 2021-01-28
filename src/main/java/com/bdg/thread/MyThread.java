package com.bdg.thread;

import java.util.Random;

public class MyThread {
    public static void main(String[] args)  {
        int number = 0;
        ThreadTwo tread = new ThreadTwo();
        for (int i = 0; i < 5; i++) {
            Runnable r = () -> {
                tread.randomValue(new Random().nextInt(11));
            };
            Thread thread = new Thread(r);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number += tread.getValue();
            System.out.println("The first Thread number id: " + tread.getValue());
        }
        System.out.println("The value of sum is: " + number);

    }
}
