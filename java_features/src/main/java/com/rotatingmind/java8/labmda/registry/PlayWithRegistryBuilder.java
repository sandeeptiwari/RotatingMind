package com.rotatingmind.java8.labmda.registry;

import com.rotatingmind.java8.labmda.model.Rectangle;
import com.rotatingmind.java8.labmda.model.Shape;
import com.rotatingmind.java8.labmda.model.Square;
import com.rotatingmind.java8.labmda.model.Triangle;

import java.util.function.Consumer;

public class PlayWithRegistryBuilder {

    public static void main(String[] args) {
        Consumer<Builder<Shape>> consumer =
                builder -> builder.register("rectangle", Rectangle::new);

        Consumer<Builder<Shape>> consumer1 =
                builder -> builder.register("square", Square::new);

        Consumer<Builder<Shape>> consumer2 =
                builder -> builder.register("triangle", Triangle::new);

        Registry registry = Registry.createRegistry(consumer.andThen(consumer1).andThen(consumer2),
                s -> { throw new IllegalArgumentException("Unknown shape: " + s); });
        System.out.println(registry.buildShapeFactory("rectangle").newInstance());
    }

}
