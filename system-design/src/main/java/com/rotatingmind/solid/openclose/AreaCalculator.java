package com.rotatingmind.solid.openclose;

import java.util.List;

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        int sum = 0;
        for (Shape shape: shapes) {
            if (shape.getClass().equals(Circle.class)) {
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            } else if (shape.getClass().equals(Rectangle.class)) {
                sum += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
            }
        }
        return sum;
    }
}
