package com.rotatingmind.designpattern.abstract_factory;

public class Espresso extends Coffee {
    public Espresso(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void brew() {

    }

    @Override
    public void boil() {

    }
}
