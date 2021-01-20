package concurrency;

import java.util.Random;

public class MyThread implements  Runnable {
        int x;
    public void run(){
       rand_sum();
    }
     public MyThread(int x){
        this.x=x;
    }

    public void rand_sum(){
        Random rand = new Random();
        int n=11;
        int int_random=rand.nextInt(n);
        System.out.println("number random :" + int_random);
        x+=int_random;


    }


}
class Main{
    public static void main(String[] args) {
        int base=0;
        MyThread  my=new MyThread(base);
        Thread thread1=new Thread(my);
        Thread thread2=new Thread(my);
        Thread thread3=new Thread(my);
        Thread thread4=new Thread(my);
        Thread thread5=new Thread(my);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
       thread5.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("final result: " + my.x);

        }

    }
