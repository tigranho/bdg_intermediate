package com.bdg.thread;

import java.util.Random;

/**
 * @author Artur
 */
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {

            new Thread(() -> {
                System.out.println(sum() + " " + Thread.currentThread().getName());
            }).start();
        }
        Thread.currentThread().join(1000);
        System.out.println(sum() + " " + Thread.currentThread().getName());
    }

    public synchronized static int sum() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += new Random().nextInt(10);
        }
        return sum;
    }
}
