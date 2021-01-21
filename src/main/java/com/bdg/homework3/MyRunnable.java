package com.bdg.homework3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class MyRunnable implements Runnable {
    public volatile AtomicInteger sum = new AtomicInteger(0);

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int next = random.nextInt(1,10);
        sum.addAndGet(next);


        System.out.println(threadName + "::" + next);
    }


}
