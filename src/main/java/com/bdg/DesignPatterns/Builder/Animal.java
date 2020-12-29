package com.bdg.DesignPatterns.Builder;


class Main{
    public static void main(String[] args) {
        Animal animal = new AnimalBuilder()
                .setFood("meat")
                .setId(15)
                .setName("Tiger")
                .build();

    }
}



public class Animal {
    private int id;
    private String name;
    private String food;

    public Animal(int id,String name,String food){
        this.id=id;
        this.name=name;
        this.food=food;
    }
}
class AnimalBuilder {
    private int id;
    private String name;
    private String food;

    public AnimalBuilder setId(int id){
        this.id=id;
        return this;
    }
    public AnimalBuilder setName(String name){
        this.name=name;
        return this;
    }
    public AnimalBuilder setFood(String food){
        this.food=food;
        return this;
    }

    public Animal build(){
        return new Animal(id,name,food);
    }


}
