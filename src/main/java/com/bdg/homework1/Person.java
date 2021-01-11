/*
package com.bdg.homework1;

*/
/**
 * @author Ara
 * builder pattern example with immutable fields
 *//*

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //all getters no setter for immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }

    public static class PersonBuilder
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }
        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the final Person object
        public Person build() {
            return  new Person(this);
        }
    }

    public static void main(String[] args) {
        Person user1 = new Person.PersonBuilder("Jack", "Jackson")
                .age(74)
                .phone("158795857")
                .address("Fake address 1111")
                .build();

        System.out.println(user1);

        Person user2 = new Person.PersonBuilder("Steven", "Gerrard")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);
    }
}

*/
