package com.rotatingmind.designpattern.abstract_factory;

public class EspressoIngredientFactory implements IngredientFactory{
    @Override
    public Bean getBean() {
        return new FrenchBean();
    }

    @Override
    public Sugar getSugar() {
        return new BrownSugar();
    }

    @Override
    public Milk getMilk() {
        return new PowderedMilk();
    }
}
