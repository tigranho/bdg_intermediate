package com.bdg.producer.consumer;

public class Main {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();

        Producer producer1 = new Producer(wareHouse);
        Producer producer2 = new Producer(wareHouse);
        Producer producer3 = new Producer(wareHouse);
        Producer producer4 = new Producer(wareHouse);
        Producer producer5 = new Producer(wareHouse);

        Consumer consumer1 = new Consumer(wareHouse);
        Consumer consumer2 = new Consumer(wareHouse);
        Consumer consumer3 = new Consumer(wareHouse);
        Consumer consumer4 = new Consumer(wareHouse);
        Consumer consumer5 = new Consumer(wareHouse);

        Thread pro1 = new Thread(producer1);
        Thread pro2 = new Thread(producer2);
        Thread pro3 = new Thread(producer3);
        Thread pro4 = new Thread(producer4);
        Thread pro5 = new Thread(producer5);

        Thread con1 = new Thread(consumer1);
        Thread con2 = new Thread(consumer2);
        Thread con3 = new Thread(consumer3);
        Thread con4 = new Thread(consumer4);
        Thread con5 = new Thread(consumer5);

        pro1.start();
        pro2.start();
        pro3.start();
        pro4.start();
        pro5.start();
        con1.start();
        con2.start();
        con3.start();
        con4.start();
        con5.start();
    }
}
