package examples_from_the_book.chapter_2._2purpose_of_an_interfaces;

import java.util.List;

public class DummyRaceManager implements RaceManager {
    @Override
    public Animal getWinner(List<Animal> animals) {
        return animals == null || animals.size() == 0?null:animals.get(0);
    }
}
