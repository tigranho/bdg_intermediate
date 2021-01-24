package com.bdg.concurrent.producerConsumer;

public class Producer implements Runnable {

    Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            warehouse.produce();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
