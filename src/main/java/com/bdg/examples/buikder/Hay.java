package com.bdg.examples.buikder;

public class Hay extends  Food {

    public Hay(int qu){
        super(qu);
    }

    @Override
    public void consumed() {
        System.out.println("hey eaten"+getQuantity());
    }
}
