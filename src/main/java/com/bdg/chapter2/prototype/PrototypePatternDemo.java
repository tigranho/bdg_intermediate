package com.bdg.chapter2.prototype;

/**
 * @author Tigran
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {


       Circle circle  = new Circle();
       Circle copyedCircle  = (Circle) circle.clone();

       Rectangle rectangle  = new Rectangle();
       Rectangle copyedRectangle  = (Rectangle) circle.clone();
    }


}
