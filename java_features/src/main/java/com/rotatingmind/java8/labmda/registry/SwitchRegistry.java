package com.rotatingmind.java8.labmda.registry;

import com.rotatingmind.java8.labmda.factory.Factory;
import com.rotatingmind.java8.labmda.model.Rectangle;
import com.rotatingmind.java8.labmda.model.Shape;
import com.rotatingmind.java8.labmda.model.Square;
import com.rotatingmind.java8.labmda.model.Triangle;


public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {
        switch (shape) {
            case "square":
                return () -> new Square();
            case "triangle":
                return () -> new Triangle();
            case "rectangle":
                return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }
}
