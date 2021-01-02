package design_pattern;

public class Factory {
    public static void main(String[] args) {
        ShapeFactory1 shapeFactory = new ShapeFactory1();
        Shape1 shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape1 shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Shape1 shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
        System.out.println();
    }
}
interface Shape1 {
    void draw();
}
class Rectangle1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Square1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
class Circle1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
class ShapeFactory1 {


    public Shape1 getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle1();

        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle1();

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square1();
        }

        return null;
    }
}