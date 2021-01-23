package com.bdg.consumerProducerExample;

public class Consumer implements Runnable{
    WareHouse wareHouse;

    public Consumer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
    }

    public synchronized void consume(){
        while(true) {
            if(wareHouse.arrayList.size() > 0){
                int data = wareHouse.arrayList.remove(0);
                System.out.println("Remove product = " + data);
            }
        }

    }

    @Override
    public void run() {
        if(wareHouse.arrayList.size() > 1) {
            consume();
        }
        else {
            try {
                Consumer.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                notify();
            }
        }
    }
}
