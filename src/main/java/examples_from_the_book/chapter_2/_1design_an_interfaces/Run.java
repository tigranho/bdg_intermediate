package examples_from_the_book.chapter_2._1design_an_interfaces;

public interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
