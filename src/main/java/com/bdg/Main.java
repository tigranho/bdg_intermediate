package com.bdg;

/**
 * @author Artur
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Test");
        //Test composition example
        Person person = new Person();
        long salary = person.getSalary();
        System.out.println(salary);
        //Test Aggregation
        Product p1 = new Product(1, "Pen", "This is red pen");
        Product p2 = new Product(2, "Pencil", "This is pencil");
        // Create lineItem and add quantity of the products
        LineItem item1 = new LineItem(1, 2, p1);
        LineItem item2 = new LineItem(1, 2, p2);
        // Before deleting line item 1
        System.out.println(item1.getId());
        System.out.println(item1.getQuantity());
        System.out.println(item1.getP());
        item1 = null;

        // Still product exist and not deleted
        System.out.println(p1);
    }

}
