package com.rotatingmind.designpattern.decorator.food;

public abstract class FoodDecorator implements Food {
    private final Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }

    @Override
    public String prepareFood() {
        return food.prepareFood();
    }

    @Override
    public double foodPrice() {
        return food.foodPrice();
    }
}
