package com.rotatingmind.designpattern.decorator.food;

public class VegFood implements Food {

    public VegFood() {
        //super(food);
    }

    @Override
    public String prepareFood() {
        return "Veg Food";
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}
