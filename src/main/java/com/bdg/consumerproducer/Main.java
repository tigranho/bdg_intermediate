package com.bdg.consumerproducer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyArray data = new MyArray();
        Producer p1 = new Producer(data);
        Producer p2 = new Producer(data);
        Consumer c1 = new Consumer(data);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(c1);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(9000);
        p1.terminate();
        p2.terminate();
    }
}
