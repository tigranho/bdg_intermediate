package com.bdg.first;

public class DogSinglton {
    private static DogSinglton instance;
    private DogSinglton() {
    }
    public static DogSinglton getInstance(){
        if (instance == null){
            instance = new DogSinglton();
        }
        return instance;
    }
}
