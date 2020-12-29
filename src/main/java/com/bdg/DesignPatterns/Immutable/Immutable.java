package com.bdg.DesignPatterns.Immutable;

import java.util.ArrayList;

public class Immutable {
    private final int i ;
    private final String s ;
    private final ArrayList<String> myList;

    public Immutable(int i,String s,ArrayList<String> myList){
        this.i=i;
        this.s=s;
        this.myList=myList;

    }

    final public int getI(){
        return i;
    }
    final public String getS(){
        return s;
    }
    final public ArrayList<String> getMyList(){
        return new ArrayList<>(myList);
    }


}

class Main {
    public static void main(String[] args) {

    }
}
