package com.bdg.homework3.thread2.waitNotify;

/**
 * Producer class, implements Runnable,
 * this thread responsible for adding products in store
 */
public class Producer implements Runnable{

    private Store store;

    public Producer(Store store){
        this.store=store;
    }

    /**
     * we use this store.put method only 6 times,
     * but can do how much we want
     */
    public void run(){
        for (int i = 1; i < 10; i++) {
            store.put();
        }
    }
}
