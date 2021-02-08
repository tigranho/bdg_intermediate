package designPatterns;

public class LlamaTrainer {
    public boolean feedLlamas(int numberOfLlamas) {
        int feedNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getHayQuantity() < feedNeeded) {
            hayStorage.addHay(feedNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(feedNeeded);
        if (fed)
            System.out.println("Llamas have been fed");
        return fed;
    }
}
