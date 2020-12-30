package examples_from_the_book.chapter_2._1design_an_interfaces;

public class Frog implements Swim, Hop{

    @Override
    public int num() {
        return 15;
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println(frog.num());
    }
}
