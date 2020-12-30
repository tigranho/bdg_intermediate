package examples.from.the.book.chapter_2._2purpose.of.an.interfaces;

import java.util.List;

@FunctionalInterface
public interface RaceManager {
    public Animal getWinner(List<Animal> animals);
//    public void run();
}
