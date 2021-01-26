package com.bdg.examples.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread tr = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 1000; i++) {
                counter.count.incrementAndGet();

            }
        });

        tr.start();
        tr.join();
        System.out.println(counter.count);

    }
}


class Counter {
    public AtomicInteger count = new AtomicInteger(0);
}

