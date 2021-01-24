package com.bdg.examples.pattern;

import java.util.ArrayList;
import java.util.List;

public final class Animlas implements Cloneable{
    private final List<String> favoriteFood;

    public Animlas(List<String> favoriteFood) {
        if (favoriteFood == null) {
            throw new RuntimeException("is required");
        }
        this.favoriteFood = new ArrayList<>(favoriteFood);
    }

    public List<String> getFavoriteFood() {
        return favoriteFood;
    }
}
