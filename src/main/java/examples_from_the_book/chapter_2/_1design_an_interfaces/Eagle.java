package examples_from_the_book.chapter_2._1design_an_interfaces;

public class Eagle implements Fly {
    @Override
    public int getWingSpan() {
        return 15;
    }

    @Override
    public void land() {
        System.out.println("Eagle is diving fast");
    }
}
