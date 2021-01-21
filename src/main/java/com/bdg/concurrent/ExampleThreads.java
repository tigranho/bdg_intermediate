package com.bdg.concurrent;

import java.util.Arrays;
import java.util.Random;

public class ExampleThreads {

    public static void main(String[] args) throws InterruptedException {

        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        Thread1 t4 = new Thread1();
        Thread1 t5 = new Thread1();

        for (Thread thread : Arrays.asList(t1, t2, t3, t4, t5)) {
            thread.start();
            thread.join();
        }
        System.out.println(Thread1.sum);
    }

    static class Thread1 extends Thread {

        static int sum = 0;

        public synchronized void run() {
            int x = new Random().nextInt(11);

            sum += x;
        }
    }
}