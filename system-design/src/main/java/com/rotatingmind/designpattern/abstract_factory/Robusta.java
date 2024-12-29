package com.rotatingmind.designpattern.abstract_factory;


public class Robusta extends Coffee {
    public Robusta(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void brew() {

    }

    @Override
    public void boil() {

    }
}
