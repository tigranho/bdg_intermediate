package com.bdg.homework3.thread2.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // shared queue created using LinkedBlockingQueue
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
        // Producer thread creation
        Thread producer = new Thread(new Producer(blockingQueue));
        // Consumer thread creation
        Thread consumer = new Thread(new Consumer(blockingQueue));

        // Start Producer and Consumer thread
        producer.start();
        consumer.start();
    }
}
