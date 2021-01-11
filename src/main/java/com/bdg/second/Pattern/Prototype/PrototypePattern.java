package com.bdg.second.Pattern.Prototype;

public class PrototypePattern implements Cloneable {
    public static void main(String[] args) {
     Dog dog = new Dog();
     Dog copyDog = (Dog) dog.clone();

     Leopard leopard = new Leopard();
     Leopard copyLeopard = (Leopard) leopard.clone();
    }
}
