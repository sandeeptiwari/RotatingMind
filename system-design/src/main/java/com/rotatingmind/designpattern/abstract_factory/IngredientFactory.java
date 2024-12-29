package com.rotatingmind.designpattern.abstract_factory;


public interface IngredientFactory {

    Bean getBean();

    Sugar getSugar();

    Milk getMilk();

}
