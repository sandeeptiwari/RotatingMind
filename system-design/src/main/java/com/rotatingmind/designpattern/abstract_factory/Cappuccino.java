package com.rotatingmind.designpattern.abstract_factory;

public class Cappuccino extends Coffee {

    public Cappuccino(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void brew() {

    }

    @Override
    public void boil() {

    }
}



