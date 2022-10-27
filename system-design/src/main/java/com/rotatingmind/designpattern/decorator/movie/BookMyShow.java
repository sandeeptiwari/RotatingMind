package com.rotatingmind.designpattern.decorator.movie;

public class BookMyShow {

    public static void main(String[] args) {
        MovieBookingDecorator decorator = new MovieBookingDecorator(
                new Platinum(new PopCorn())
        );

        System.out.println(decorator.getDescription() + " Rs. " + decorator.cost());
    }
}
