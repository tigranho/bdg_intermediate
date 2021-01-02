package design_principle;

import java.awt.*;
import java.util.ArrayList;

public class Aggregation {
    public static void main(String[] args) {
        Address ad=new Address("Armenia","Artashat","Shirvanzade",14);
        Student st=new Student(12,"Soghomonyan","Anna",ad);
        System.out.println(st.firstname);
        System.out.println(st.lastname);
        System.out.println(st.id);
        System.out.println(st.studnet_address.country);
        System.out.println(st.studnet_address.city);
        System.out.println(st.studnet_address.street);
        System.out.println(st.studnet_address.home_number);

    }
}
class Address {
    String country;
    String city;
    String street;
    int home_number;


    public Address(String country, String city, String street, int home_number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.home_number = home_number;
    }
}
class Student {
    int id;
    String lastname;
    String firstname;
    Address studnet_address;

    public Student(int id, String lastname, String firstname, Address studnet_address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.studnet_address = studnet_address;
    }
}