package com.bdg.examples;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
//        String[] str = new String[10];
//        Optional<String> empty = Optional.empty();
//        System.out.println(empty);
//        Optional<String> value = Optional.of(str[5]);
//        System.out.println(value.filter(s -> s.equals("Abs")));
//        System.out.println(value.get());
//        System.out.println(value.hashCode());
//        System.out.println(value.isPresent());
//        System.out.println(Optional.ofNullable(str[5]));
//        System.out.println(value.orElse("Value is not present"));
//        System.out.println(empty.orElse("value is not presten"));
//        value.ifPresent(System.out::println);

        String[] str = new String[10];
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> value = Optional.of(str[5]);
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
        System.out.println("Getting value: " + value.get());
        System.out.println("Getting hashCode: " + value.hashCode());
        System.out.println("Is value present: " + value.isPresent());
        System.out.println("Nullable Optional: " + Optional.ofNullable(str[5]));
        System.out.println("orElse: " + value.orElse("Value is not present"));
        System.out.println("orElse: " + empty.orElse("Value is not present"));
        value.ifPresent(System.out::println);   // printing value by using method reference

    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }
}
