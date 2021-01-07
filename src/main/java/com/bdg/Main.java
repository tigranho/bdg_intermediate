package com.bdg;

import com.bdg.design_pattern.factory_immutable_builder.Card;
import com.bdg.design_principles.LineItem;
import com.bdg.design_principles.Person;
import com.bdg.design_principles.Product;
import com.bdg.design_pattern.factory_immutable_builder.Shape;
import com.bdg.design_pattern.factory_immutable_builder.ShapeFactory;

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
        //Test Factory Pattern
        ShapeFactory shapeFactory = new ShapeFactory();
        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //call draw method of Circle
        shape1.draw();
        //Test builder Pattern
        Card card=new Card.CardBuilder().number(1225l).cardBuild();
        System.out.println(card.getNumber());

    }
}
