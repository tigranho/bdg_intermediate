package com.bdg.homework.threeds.taskConsumer;

import java.util.Random;
import java.util.RandomAccess;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        ManageProducts<Integer> manageProducts = new ManageProducts();


        Thread producerThread = new Thread(() -> {
            try {
                int item;
                while (true) {
                    item = new Random().nextInt(10);
                    ;
                    manageProducts.addProductIntoStore(item);
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();


            }
        });


        Thread consumeThread = new Thread(() -> {
            try {
                    while (true) {

                    manageProducts.getProductIntoStore();


                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();


            }
        });

        producerThread.start();

        consumeThread.start();


    }
}
