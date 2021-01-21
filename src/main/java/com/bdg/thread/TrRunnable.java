package com.bdg.thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class TrRunnable extends Thread {
    public volatile AtomicInteger sum = new AtomicInteger(0);

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int next = random.nextInt(1, 10);
        sum.addAndGet(next);

        System.out.println(threadName + "::" + next);
    }
}
