package com.rotatingmind.designpattern.decorator.movie;

public class PopCorn extends Facility {

    public PopCorn() {
        description = "PopCorn";
    }
    public String getDeString() {
        return description;
    }

    @Override
    public double cost() {
        return 50.0;
    }
}
