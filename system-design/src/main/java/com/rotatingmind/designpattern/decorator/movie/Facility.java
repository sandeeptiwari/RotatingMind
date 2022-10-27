package com.rotatingmind.designpattern.decorator.movie;

public abstract class Facility {

    public String description = "No Facility";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
