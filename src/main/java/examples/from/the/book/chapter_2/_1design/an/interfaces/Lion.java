package examples.from.the.book.chapter_2._1design.an.interfaces;

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
