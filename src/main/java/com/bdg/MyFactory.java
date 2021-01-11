package com.bdg;

class MyFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        WhiteBread whiteBread = (WhiteBread) factory.creat("White");
        BlackBread blackBread = (BlackBread) factory.creat("Black");
        whiteBread.breadType();
        blackBread.breadType();
    }

}

interface Bread {
    void breadType();
}

class WhiteBread implements Bread {

    public void breadType() {
        System.out.println("It is white bread");
    }
}

class BlackBread implements Bread {

    public void breadType() {
        System.out.println("It is black bread");
    }
}

class Factory {
    public Bread creat(String bread) {
        if ("White".equals(bread)) {
            return new WhiteBread();
        } else if ("Black".equals(bread)) {
            return new BlackBread();
        } else {
            return null;
        }

    }
}