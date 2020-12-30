package examples_from_the_book.chapter_2._2purpose_of_an_interfaces;

import java.util.List;

@FunctionalInterface
public interface RaceManager {
    public Animal getWinner(List<Animal> animals);
//    public void run();
}
