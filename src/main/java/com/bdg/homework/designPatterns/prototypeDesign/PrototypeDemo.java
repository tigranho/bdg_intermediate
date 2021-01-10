package com.bdg.homework.designPatterns.prototypeDesign;

public class PrototypeDemo {

    public static void main(String[] args) {

        Registry registry= new Registry();
        Movie movie= (Movie) registry.createItem("Movie");
        movie.setTitle(" Just learn Java");

        System.out.println(movie);
        System.out.println(movie.getTitle());
        System.out.println(movie.getPrice());
        System.out.println(movie.getUrl());

        Movie onotherMovie= (Movie) registry.createItem("Movie");
        movie.setTitle(" Just learn onother Java");

        System.out.println(onotherMovie);
        System.out.println(onotherMovie.getTitle());
        System.out.println(onotherMovie.getPrice());
        System.out.println(onotherMovie.getUrl());


    }




}
