package com.bdg.threads.producer_consumer.producer;

import com.bdg.threads.producer_consumer.warehouse.WareHouse;

public class Producer implements Runnable {

    private WareHouse wareHouse;

    public Producer(final WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        try {
            wareHouse.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
