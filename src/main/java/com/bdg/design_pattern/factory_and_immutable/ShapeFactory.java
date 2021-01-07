package com.bdg.design_pattern.factory_and_immutable;

import com.bdg.design_pattern.factory_and_immutable.Circle;
import com.bdg.design_pattern.factory_and_immutable.Rectangle;
import com.bdg.design_pattern.factory_and_immutable.Shape;
import com.bdg.design_pattern.factory_and_immutable.Square;

/**
 * @author Artur
 * Factory Pattern example
 */

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
}
