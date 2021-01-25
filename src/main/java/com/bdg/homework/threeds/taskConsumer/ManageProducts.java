package com.bdg.homework.threeds.taskConsumer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ManageProducts<E> {
    private Queue<E> listOfItems;
    private final int maxSize=10;
    private ReentrantLock lock = new ReentrantLock(true);

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public ManageProducts( ) {
        this.listOfItems = new LinkedList<>();
     }


    public void addProductIntoStore(E item) throws InterruptedException {

        lock.lock();
        try {
            if (listOfItems.size() == maxSize) {

                notFull.await();
            }

            listOfItems.add(item);
            System.out.println( " size----- "+ listOfItems.size());
            notEmpty.signalAll();

            System.out.println("Produced - " + item);
        } finally {
            lock.unlock();
        }


    }


    public void getProductIntoStore() throws InterruptedException {

        lock.lock();
        try {


            if (listOfItems.size() == 0) {

                notEmpty.await();
            }
            E e = listOfItems.remove();

            notFull.signalAll();

            System.out.println("Consumer - " + e);
         } finally {
            lock.unlock();
        }


    }


}
