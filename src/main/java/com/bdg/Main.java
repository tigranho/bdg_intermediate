package com.bdg;


import java.awt.*;

/**
 * @author Ruzanna
 */


public class Main {
    public static void main(String[] args) {
        LlamaTrainer trainer = new LlamaTrainer();
        HayStorage hayStorage = HayStorage.getInstance();
        trainer.feedLlamas(20);
        System.out.println(hayStorage.getHayQuantity());
        trainer.feedLlamas(10);
        System.out.println(hayStorage.getHayQuantity());
    }

}
