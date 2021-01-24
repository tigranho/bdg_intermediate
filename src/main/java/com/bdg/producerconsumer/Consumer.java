package com.bdg.producerconsumer;

import java.util.List;

public class Consumer extends Thread {
    List<Integer> wareHouse;
    int value ;


    public Consumer(List<Integer> wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        synchronized (this){
        while (wareHouse.size() <= 0 )
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Producer producer = new Producer(wareHouse);
        wareHouse.remove(producer.retrunValue());
        notify();

    }}
}