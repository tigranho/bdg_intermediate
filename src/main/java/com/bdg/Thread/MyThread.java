package com.bdg.Thread;

public class MyThread
    extends Thread {

        MyThread(String name){
            super(name);
        }

        public void run(){

            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s fiished... \n", Thread.currentThread().getName());
        }
    }




