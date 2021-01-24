package com.bdg.producer.consumer;

public class Producer implements Runnable{
    WareHouse wareHouse;

    public Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    public synchronized void produce(){
        int i = 0;
        while(true) {
            if(wareHouse.arrayList.size() < wareHouse.maxSize){
                wareHouse.arrayList.add(++i);
                System.out.println("Add product = " + i);
            }
        }

    }

    @Override
    public void run() {
        if(wareHouse.arrayList.size() < wareHouse.maxSize-1) {
            produce();
        }
        else {
            try {
                Producer.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                notify();
            }
        }

    }
}
