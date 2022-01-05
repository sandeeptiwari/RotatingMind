package com.rotatingmind.java8.labmda.factory;

import java.awt.*;
import java.util.List;

public class PlayWithFactory {

    public static void main(String[] args) {
        Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        Circle circle = factory.newInstance();

        System.out.println("Circle " + circle);

        List<Circle> circles = factory.create5();
        System.out.println(circles);
    }
}
