package com.bdg;

/**
 * @author Tigran
 */
public class Main {

    public static void main(String[] args) {
        UserJavaBean user = new UserJavaBean();
        user.setName("Jack");
        user.setAge(18);
        user.setEmail("Jack2002@gmail.com");
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getEmail());


        HumanAggregation humanAggregation = new HumanAggregation();
        humanAggregation.address.getCity();
        humanAggregation.address.getCountry();

        CarComposition carComposition = new CarComposition();
        carComposition.mator.setPower(2);

    }


}
