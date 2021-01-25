package com.bdg.homework3.thread2.waitNotify;

/**
 * Consumer class, implements Runnable,
 * this thread responsible for taking products from store
 */
public class  Consumer implements Runnable{

    private Store store;

    public Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 10; i++) {
            store.get();
        }
    }
}