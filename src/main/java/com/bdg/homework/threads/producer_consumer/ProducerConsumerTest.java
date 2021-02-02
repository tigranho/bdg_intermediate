package com.bdg.homework.threads.producer_consumer;

import com.bdg.homework.threads.producer_consumer.consumer.Consumer;
import com.bdg.homework.threads.producer_consumer.producer.Producer;
import com.bdg.homework.threads.producer_consumer.warehouse.WareHouse;

public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        WareHouse wareHouse = new WareHouse();

        Consumer consumer = new Consumer(wareHouse);
        Producer producer = new Producer(wareHouse);

        Thread consumers = new Thread(consumer);
        consumers.start();

        Thread produsers = new Thread(producer);
        produsers.start();

    }
}
