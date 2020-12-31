package immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Animal class test
        /*List<String> l = new ArrayList<>();
        l.add("apple");
        l.add("banana");
        Animal animal = new Animal("Elephant",10,l);
        System.out.println("Elephant info ....");
        System.out.println(animal.getAge());
        System.out.println(animal.getFavoriteFoodsCount());
        System.out.println(animal.getSpecies());
        System.out.println(animal.getFavoriteFood(1));
        l.remove(1);
        //System.out.println(animal.getFavoriteFood(1));
        List<String> l1 = new ArrayList<>();
        l1.add("Cocos");
        l1.add("PineApple");
        Animal a1 = new Animal("Rabbit",15,l1);
        System.out.println("Rabbit info ....");
        System.out.println(a1.getAge());
        System.out.println(a1.getFavoriteFoodsCount());
        System.out.println(a1.getSpecies());
        System.out.println(a1.getFavoriteFood(0));*/

        //AnimalBuilder class test
        Animal animalBuilder = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("algae","insects"))
                .setSpecies("flamingo").build();
        System.out.println(animalBuilder.getFavoriteFood(0)+" , "+animalBuilder.getSpecies()
        + " , "+animalBuilder.getAge());
    }
}
