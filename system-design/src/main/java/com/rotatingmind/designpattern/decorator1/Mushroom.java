package com.rotatingmind.designpattern.decorator1;

public class Mushroom extends Topping{

    public Mushroom(Pizza pizza) {
        super("Mushroom", 4, pizza);
    }

}
