package com.bdg.producerconsumer;

import java.util.List;

public class Producer extends Thread {
    List<Integer> wareHouse;
    int value = 0;
    public int retrunValue(){
        return value++;
    }

    public Producer(List<Integer> wareHouse) {
        this.wareHouse = wareHouse;
    }


    @Override
    public void run() {
        synchronized (this){
        while (wareHouse.size() >= 5 )
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wareHouse.add(value++);
        notify();
    }}
}
