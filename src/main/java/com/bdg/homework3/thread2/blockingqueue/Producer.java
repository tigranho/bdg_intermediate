package com.bdg.homework3.thread2.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

private final BlockingQueue<Integer> blockingQueue;

public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        }

public void run() {

        for (int i = 1; i <= 50; i += 10) {
            try {
                System.out.println(String.format("Producer produced data %s and added to queue.",i));
                blockingQueue.put(i);
           } catch (InterruptedException ex) {
                System.out.println("Producer thread is interrupted.");
           }
        }
    }
}
