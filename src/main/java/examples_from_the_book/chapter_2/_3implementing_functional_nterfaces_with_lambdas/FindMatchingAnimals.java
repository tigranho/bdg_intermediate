package examples_from_the_book.chapter_2._3implementing_functional_nterfaces_with_lambdas;

public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTrait trait) {
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish", true,true), a -> a.isCanHop());
        print(new Animal("kangaroo", true,false), a -> a.isCanHop());
    }
}
