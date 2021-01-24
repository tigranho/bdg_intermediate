package com.bdg.examples.pattern;

public class VisitorTicketTracker {
    private static VisitorTicketTracker instance;

    private VisitorTicketTracker() {

    }

    public static VisitorTicketTracker getInstance() {
        if (instance == null) {
            instance = new VisitorTicketTracker();
        }
        return instance;
    }

}
