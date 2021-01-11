package com.bdg.homework1;

/**
 * @author Ara
 * class for aggregation
 */
public class Passport {
    private int number;
    private String givenBy;

    public Passport(int number, String givenBy) {
        this.number = number;
        this.givenBy = givenBy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }


}
