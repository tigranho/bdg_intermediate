package com.bdg.examples.buikder;

public class M {
    public static void main(String[] args) {
        Account sss = Account.newBuilder()
                .setName("sss").build();

        System.out.println(sss.getName());

    }
}
