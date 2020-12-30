package com.bdg.pattern.prototype;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "arsen777", 14.5);
        System.out.println(user);

        User clone1 = (User) user.createClone();
        User clone2 = (User) clone1.createClone();
        User clone3 = (User) user.createClone();

        clone1.setId(2);
        clone3.setId(4);
        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
    }
}
