package com.rotatingmind.designpattern.decorator.food;

public class ChineeseFood extends FoodDecorator {

    public ChineeseFood(Food food) {
        super(food);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " With Fried Rice and Manchurian  ";
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 80;
    }
}
