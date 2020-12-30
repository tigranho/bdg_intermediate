package examples_from_the_book.chapter_2._3implementing_functional_nterfaces_with_lambdas;

public class Animal {
    private String spacies;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String spaciesName, boolean hopper, boolean swimmer){
        spacies = spaciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean isCanHop (){
        return canHop;
    }

    public boolean isCanSwim(){
        return canSwim;
    }

    public String toString (){
        return spacies;
    }
}
