package examples.from.the.book.chapter_2._3implementing.functional.nterfaces.with.lambdas;

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
