package com.bdg.secondhomework.Pattern.Factory;

public class DogFactory extends DogAbstractFactory {
    public  Dog getDog(String criteria) {
        if (criteria.equals("small"))
            return new Poodle();
        else if (criteria.equals("big"))
            return new Rotfelier();
        else if (criteria.equals("working"))
            return new Husky();

        return null;
    }
}
