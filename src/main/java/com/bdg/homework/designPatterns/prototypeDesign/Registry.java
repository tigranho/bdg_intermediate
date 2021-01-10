package com.bdg.homework.designPatterns.prototypeDesign;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, Item> itemMap = new HashMap<>();


    public Registry() {
        loadItem();
    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item) (itemMap.get(type)).clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.fillInStackTrace();
        }

        return item;
    }


    private void loadItem() {
        Movie movie = new Movie();
        movie.setTitle("Intersteller");
        movie.setRuntime("2 hours");
        movie.setPrice(19.99);
        movie.setUrl("//Http.something");
        itemMap.put("Movie", movie);


        Book book = new Book();
        book.setTitle("something");
        book.setPrice(77.497);
        book.setUrl("//http.something");
        book.setNumberOfPage(111);
        itemMap.put("Book", book);


    }
}
