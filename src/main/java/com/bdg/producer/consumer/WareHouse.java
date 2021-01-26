package com.bdg.producer.consumer;


import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    List<Integer> orderList;
    int maxOrder = 10;

    public WareHouse() {
        orderList = new ArrayList<>();
    }


    public void produce() throws InterruptedException {
        synchronized (this) {
            int order = 1;

            while (true) {
                if (orderList.size() == maxOrder) {
                    wait();
                } else {
                    Thread.sleep(100);
                    orderList.add(order++);
                    System.out.println("Order No: " + order + " is ready to served");
                    notifyAll();
                }
            }
        }
    }

    public void serve() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (orderList.isEmpty()) {
                    wait(10);
                } else {
                    System.out.println("Serving order no: " + orderList.remove(0));
                    notifyAll();
                }
            }
        }
    }
}
