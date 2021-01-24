package com.bdg.producer.consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WareHouse wareHouse = new WareHouse();
        Runnable runnableProducer1 = new Producer(wareHouse);
        Thread threadProducer1 = new Thread(runnableProducer1);
        threadProducer1.start();
        Runnable runnableProducer2 = new Producer(wareHouse);
        Thread threadProducer2= new Thread(runnableProducer2);
        threadProducer2.start();


        Runnable runnableConsumer1 = new Consumer(wareHouse);
        Thread threadConsumer1 = new Thread(runnableConsumer1);
        threadConsumer1.start();
        Runnable runnableConsumer2 = new Consumer(wareHouse);
        Thread threadConsumer2 = new Thread(runnableConsumer2);
        threadConsumer2.start();


        threadConsumer1.join();
        threadConsumer2.join();
        threadProducer1.join();
        threadProducer2.join();
    }
}
