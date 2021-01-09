package com.bdg.designPatterns.factory;

public class PetrolFactory extends AbstractFactory{

    @Override
    public Petrol getPetrol(String carType) {
        switch (carType){
            case "BMW":
                return new Premium(65);
            case "Ferrari":
                return new Super(90);
            case "Lada":
                return new Regular(50);
        }
        throw new UnsupportedOperationException("Unsupported car:" + carType);
    }
}
