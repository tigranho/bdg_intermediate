package com.bdg.homework3.thread2.waitNotify;

/**
 * This class has 2 synchronized methods put and get
 * and in store we will add our products,and from here
 * we will take
 */
public class Store {

    private int product = 0;

    /**
     * this is synchronized method,through which
     * we can get products ,if products count < 1(store is empty)
     * we will call wait, so monitor for store object will be free
     * but we can not use get method while for store's monitor we do not call notify
     */
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Consumer take 1 product");
        System.out.println("Product in store: " + product);
        notify();
    }
    /**
     * this is synchronized method,through which
     * we can add products ,if products count >= 3(store is full)
     * we will call wait, so monitor for store object will be free
     * but we can not use put method while for store's monitor we do not call notify
     */
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Producer added 1 product");
        System.out.println("Products in  store: " + product);
        notify();
    }
}
