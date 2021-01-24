package com.bdg.examples.pattern;

public class LlamaTrainer {

    public boolean feedLlams(int numberOfLlamas) {
        int amountNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getQuantity() < amountNeeded) {
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);
        if (fed) {
            System.out.println("Llamas have been fed");

        }
        return fed;
    }
}
