package examples_from_the_book.chapter_2._1design_an_interfaces;

public class Lion implements Run{
    @Override
    public boolean canHuntWhileRunning() {
        return false;
    }

    @Override
    public boolean isQuadruped() {
        return false;
    }

    @Override
    public double getMaxSpeed() {
        return 100;
    }
}
