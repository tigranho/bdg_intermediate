package com.bdg.homework3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalRandomExample {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread t[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
                 t[i] = new Thread(runnable);
                t[i].setName("MyRunnable-Thread-" + i);
                t[i].start();
            }
        for (int i = 0; i < 5; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum is + " + runnable.sum);

        }

    }


