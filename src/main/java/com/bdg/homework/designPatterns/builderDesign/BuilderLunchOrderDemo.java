package com.bdg.homework.designPatterns.builderDesign;

public class BuilderLunchOrderDemo {
    public static void main(String[] args) {

        BuilderLunchOrder.Builder lunch = new BuilderLunchOrder.Builder();

        lunch
                .bread("something")
                .cola("pepsi")
                .condiments("curry")
                .meat("chicken");
        System.out.println(lunch);

    }




}

