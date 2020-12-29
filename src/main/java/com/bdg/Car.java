package com.bdg;

import java.security.PrivateKey;

public class Car {

}

//Is a Lexus Car
class Lexus extends Car {
   private Keys keys;
public  Lexus(){
    this.keys=new Keys();
keys.setCheapKey("your key is simple key");

}
public String getKey(){
   return keys.getCheapKey();
}

    public static void main(String[] args) {
        Lexus lexus=new Lexus();
String key=lexus.getKey();
        System.out.println(key);
    }
}

//Has A Lexus Key
class Keys {
   private String cheapKey;
    private String fishKey;

    public String getCheapKey() {
        return cheapKey;
    }

    public void setCheapKey(String cheapKey) {
        this.cheapKey = cheapKey;
    }

    public String getFishKey() {
        return fishKey;
    }

    public void setFishKey(String fishKey) {
        this.fishKey = fishKey;
    }
}