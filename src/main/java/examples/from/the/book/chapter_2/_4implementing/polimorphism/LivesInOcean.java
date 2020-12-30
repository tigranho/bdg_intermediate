package examples.from.the.book.chapter_2._4implementing.polimorphism;

public interface LivesInOcean {
    public void makeSound();
}

class Dolphin implements LivesInOcean{

    @Override
    public void makeSound() {
        System.out.println("whistle");
    }
}

class Whale implements LivesInOcean{
    public void makeSound(){
        System.out.println("sing");
    }

}

class Oceanographer{
    public void makeSound(LivesInOcean animal){
        animal.makeSound();
    }

    public static void main(String[] args){

    }
}
