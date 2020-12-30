package examples_from_the_book.chapter_2._1design_an_interfaces;

public interface Fly {
    public int getWingSpan() throws Exception;

    public static final int MAX_SPEED = 100;

    public default void land() {
        System.out.println("Animal is landing");
    }

    public static double colculateSpeed(float distance, double time) {
        return distance / time;
    }
}

