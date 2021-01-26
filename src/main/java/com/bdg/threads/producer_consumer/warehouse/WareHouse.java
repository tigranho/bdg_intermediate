package com.bdg.threads.producer_consumer.warehouse;

import java.util.ArrayList;

public class WareHouse {
    private final int capacity = 8;
    private final ArrayList<Integer> globbing = new ArrayList<>();


    public void produce() throws InterruptedException {
        int addProduct = 0;
        while (true) {
            synchronized (this) {
                if (globbing.size() == capacity) {
                    wait();
                }
                System.out.println("producer add things :" + addProduct);
                globbing.add(addProduct++);
                if (globbing.size() == capacity)
                notify();
                Thread.sleep(1000);
            }
        }

    }


    public void consumer() throws InterruptedException {

        while (true) {
            synchronized (this) {
                if (globbing.isEmpty()) {
                    wait();
                }
                System.out.println("consumer get things :" + globbing.get(0));
                globbing.remove(0);
                notify();
                Thread.sleep(1000);
            }
        }

    }

}
