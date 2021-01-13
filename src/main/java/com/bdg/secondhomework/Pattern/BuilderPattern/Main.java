package com.bdg.secondhomework.Pattern.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("John", "Wick")
                .age(25)
                .phone("234432")
                .address("USA")
                .build();

        System.out.println(user1);
    }
}