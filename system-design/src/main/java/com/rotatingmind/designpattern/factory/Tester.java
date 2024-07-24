package com.rotatingmind.designpattern.factory;

public class Tester {

    public static void main(String[] args) {
        CoffeeServer coffeeServer = new CoffeeServer(new CoffeeFactory());
        coffeeServer.serve("Espresso");
    }

}
