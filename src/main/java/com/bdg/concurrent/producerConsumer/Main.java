package com.bdg.concurrent.producerConsumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Warehouse warehouse = new Warehouse();

        Runnable producer = new Producer(warehouse);
        Thread producerThread = new Thread(producer);

        Runnable consumer = new Consumer(warehouse);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
