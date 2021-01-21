package com.bdg.concurrent;

import java.util.Arrays;
import java.util.Random;

public class ExampleRunnable {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Demo());
        Thread t2 = new Thread(new Demo());
        Thread t3 = new Thread(new Demo());
        Thread t4 = new Thread(new Demo());
        Thread t5 = new Thread(new Demo());

        for (Thread thread : Arrays.asList(t1, t2, t3, t4, t5)) {
            thread.start();
            thread.join();
        }
        System.out.println(Demo.sum);
    }

    static class Demo implements Runnable {

        static int sum;

        @Override
        public synchronized void run() {
            int x = new Random().nextInt(11);

            sum += x;
        }
    }
}