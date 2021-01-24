package com.bdg.concurrent.producerConsumer;

public class Consumer implements Runnable {

    Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    @Override
    public void run() {
        try {
            warehouse.consume();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
