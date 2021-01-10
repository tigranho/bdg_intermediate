package com.bdg.homework.designPatterns.prototypeDesign;

import java.util.Iterator;

public class Book  extends Item {
    private int numberOfPage;

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
}
