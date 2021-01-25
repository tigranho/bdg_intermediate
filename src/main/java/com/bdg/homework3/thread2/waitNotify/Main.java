package com.bdg.homework3.thread2.waitNotify;

import com.bdg.homework3.thread2.waitNotify.Consumer;
import com.bdg.homework3.thread2.waitNotify.Producer;
import com.bdg.homework3.thread2.waitNotify.Store;

/**
 * entrypoint for application
 */
public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
