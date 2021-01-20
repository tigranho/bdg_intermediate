package com.bdg.thread;

import java.util.Random;

/**
 * @author Artur
 */
public class TestThread {
    static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                randomNumber();
                System.out.println(Thread.currentThread().getName());
            }).start();

        }
        Thread.currentThread().join(1000);
        System.out.println(Thread.currentThread().getName() + " " + sum);
    }

    public static void randomNumber() {
        Random random = new Random();
        int rand = 0;
        while (true) {
            rand = random.nextInt(11);
            if (rand != 0) break;
        }
        sum += rand;
    }

}
