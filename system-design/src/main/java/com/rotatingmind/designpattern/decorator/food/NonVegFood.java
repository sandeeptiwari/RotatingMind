package com.rotatingmind.designpattern.decorator.food;

public class NonVegFood extends FoodDecorator {

    public NonVegFood(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() +" With Roasted Chicken and Chiken Curry  ";
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 120;
    }
}
