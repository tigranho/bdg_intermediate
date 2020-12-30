package examples.from.the.book.chapter_2._1design.an.interfaces;

public interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
