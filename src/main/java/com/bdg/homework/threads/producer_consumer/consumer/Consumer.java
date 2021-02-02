package com.bdg.homework.threads.producer_consumer.consumer;

import com.bdg.homework.threads.producer_consumer.warehouse.WareHouse;

public class Consumer implements Runnable {

    private WareHouse wareHouse;

    public Consumer(final WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }


    @Override
    public void run() {
        try {
            wareHouse.consumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
