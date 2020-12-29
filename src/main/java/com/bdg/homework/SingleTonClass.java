package com.bdg.homework;

/**
 * @author Ara
 * SingleTon class example
 */
public class SingleTonClass {
    //Static Class Reference
    private static SingleTonClass obj=null;

    //Private Constructor ensures that we cant create instance using constructor
    private SingleTonClass(){
    }

    // this method ensures that we can have only one instance of this class
    public static SingleTonClass objectCreationMethod(){
        if(obj==null){
            obj= new SingleTonClass();
        }
        return obj;
    }
    public void display(){
        System.out.println("Singleton class Example");
    }
    public static void main(String args[]){
        // since we cant create instance via constructor
        // we will do that due to static method defined in our class
        SingleTonClass myObject= SingleTonClass.objectCreationMethod();
        myObject.display();
    }
}