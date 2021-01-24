package com.bdg.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> wareHouse = new ArrayList<>();


        Producer producer1 = new Producer(wareHouse);
        Producer producer2 = new Producer(wareHouse);
        Producer producer3 = new Producer(wareHouse);

        Consumer consumer1 = new Consumer(wareHouse);
        Consumer consumer2 = new Consumer(wareHouse);
        Consumer consumer3 = new Consumer(wareHouse);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();



        producer1.join();
        producer2.join();
        producer3.join();

        consumer1.join();
        consumer2.join();
        consumer3.join();





    }
}
