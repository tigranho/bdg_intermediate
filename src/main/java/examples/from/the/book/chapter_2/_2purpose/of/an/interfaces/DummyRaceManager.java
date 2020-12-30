package examples.from.the.book.chapter_2._2purpose.of.an.interfaces;

import java.util.List;

public class DummyRaceManager implements RaceManager {
    @Override
    public Animal getWinner(List<Animal> animals) {
        return animals == null || animals.size() == 0?null:animals.get(0);
    }
}
