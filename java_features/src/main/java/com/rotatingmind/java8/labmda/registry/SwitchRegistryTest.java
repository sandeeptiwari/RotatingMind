package com.rotatingmind.java8.labmda.registry;

import com.rotatingmind.java8.labmda.factory.Factory;
import com.rotatingmind.java8.labmda.model.Shape;

public class SwitchRegistryTest {

    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();
        Factory<? extends Shape> square = registry.buildShapeFactory("square");
        System.out.println("Square " + square.newInstance());
    }
}
