package com.bdg.homework.designPatterns.singltoneDesign;

public class DbSingltoneDemo {


    /* i am going to crate two object of our singlton class , and will see the behaviour of singltone
    **/

    public static void main(String[] args) {

        DbSingltone dbSingltoneOne = DbSingltone.getInstance();
        DbSingltone dbSingltoneTwo = DbSingltone.getInstance();


        System.out.println(dbSingltoneOne);
        System.out.println(dbSingltoneTwo);

        /* as you see  the object addresses are the same **/

    }


}
