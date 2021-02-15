package com.bdg.concurrent.producer_consumer;

import java.util.ArrayList;

public class Warehouse {
    int capacity = 8;
    ArrayList<String> arrayList = new ArrayList<>();

    public void produce() throws InterruptedException {
        int productNumber = 0;
        while (true) {
            synchronized (this) {
                while (arrayList.size() == capacity) {
                    wait();
                }

                System.out.println("produced: " + productNumber);
                arrayList.add( "" + productNumber++);
                notify();
            }
        }
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (this) {
                while (arrayList.isEmpty()) {
                    wait();
                }
                System.out.println("consumed: " + arrayList.get(0));
                arrayList.remove(0);
                notify();
            }
        }
    }

}
